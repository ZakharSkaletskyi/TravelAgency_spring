package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.RoomBookDao;
import com.softserve.lv_427.travel_agency.entity.RoomBook;
import com.softserve.lv_427.travel_agency.exception.FieldNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * DAO implementation for RoomBook entity.
 *
 * @author Oleksandr Agarkov
 * @version 1.0
 */
@Repository
public class RoomBookDaoImpl implements RoomBookDao {
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Add roomBook entity to DB.
   *
   * @param roomBook - roomBook entity.
   */
  @Override
  public void add(RoomBook roomBook) {
    try (Session session = sessionFactory.openSession()) {
      session.persist(roomBook);
    }
  }

  /**
   * Get roomBook from DB by id.
   *
   * @param id - roomBook id.
   * @return roomBook entity.
   */
  @Override
  public RoomBook getById(int id) {
    try (Session session = sessionFactory.openSession()) {
      RoomBook roomBook = session.get(RoomBook.class, id);
      if (roomBook == null) {
        throw new FieldNotFoundException("There is no reservation with this name");
      } else {
        return roomBook;
      }
    }
  }

  /**
   * Delete roomBook from DB.
   *
   * @param roomBook - roomBook entity.
   */
  @Override
  public void delete(RoomBook roomBook) {
    try (Session session = sessionFactory.openSession()) {
      session.delete(roomBook);
    }
  }

  /**
   * Edit roomBook in DB.
   *
   * @param roomBook - roomBook entity.
   */
  @Override
  public void edit(RoomBook roomBook) {
    try (Session session = sessionFactory.openSession()) {
      session.update(roomBook);
    }
  }
  /** Replace booking from RoomBook to RoomBookArchive */
  @Override
  public void movePastBookingToArchive() {
    try (Session session = sessionFactory.openSession()) {
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Calendar cal = Calendar.getInstance();
      String date = dateFormat.format(cal.getTime());

      session
          .createQuery(
              "INSERT INTO RoomBookArchive "
                  + "(orderStart, orderEnd, room.id, client.id)"
                  + "select orderStart, orderEnd, room.id, client.id"
                  + " FROM RoomBook WHERE orderEnd < ?1 ")
          .setParameter(1, date);
    }
  }
  /** Deleting the old copy of roomBook which was replaced into roomBookArchive */
  @Override
  public void deletePastBookingToArchive() {
    try (Session session = sessionFactory.openSession()) {
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Calendar cal = Calendar.getInstance();
      String date = dateFormat.format(cal.getTime());

      session
          .createQuery("DELETE FROM RoomBook WHERE orderStart < ?1")
          .setParameter(1, date)
          .executeUpdate();
    }
  }
}
