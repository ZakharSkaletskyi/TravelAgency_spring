package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.RoomBookDao;
import com.softserve.lv_427.travel_agency.entity.RoomBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Repository
public class RoomBookDaoImpl implements RoomBookDao {
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void add(RoomBook roomBook) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(roomBook);
  }

  @Override
  public RoomBook getById(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(RoomBook.class, id);
  }

  @Override
  public void delete(RoomBook roomBook) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(roomBook);
  }

  @Override
  public void edit(RoomBook roomBook) {
    Session session = sessionFactory.getCurrentSession();
    session.update(roomBook);
  }

  @Override
  public void movePastBookingToArchive() {
    Session session = sessionFactory.getCurrentSession();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    String date = dateFormat.format(cal.getTime());

    session
        .createQuery(
            "INSERT INTO room_book_archive "
                + "(order_start, order_end, room.id, client.id)"
                + "select order_start, order_end, room.id, client.id"
                + " FROM room_book WHERE order_end < ?1 ")
        .setParameter(1, date);
  }

  @Override
  public void deletePastBookingToArchive() {
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    String date = dateFormat.format(cal.getTime());

    session
        .createQuery("DELETE FROM room_book WHERE order_end < ?1")
        .setParameter(1, date)
        .executeUpdate();
    tx.commit();
  }
}
