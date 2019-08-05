package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.RoomBookArchiveDao;
import com.softserve.lv_427.travel_agency.entity.Room;
import com.softserve.lv_427.travel_agency.entity.RoomBook;
import com.softserve.lv_427.travel_agency.entity.RoomBookArchive;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * DAO implementation for RoomBookArchive entity.
 *
 * @author Oleksandr Agarkov
 * @version 1.0
 */
@Repository
public class RoomBookArchiveDaoImpl implements RoomBookArchiveDao {
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Add roomBookArchive entity to DB.
   *
   * @param roomBookArchive - roomBookArchive entity.
   */
  @Override
  public void add(RoomBookArchive roomBookArchive) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.persist(roomBookArchive);
    }
  }

  /**
   * Get roomBookArchive from DB by id.
   *
   * @param id - roomBookArchive id.
   * @return roomBookArchive entity.
   */
  @Override
  public RoomBookArchive getById(int id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      RoomBookArchive roomBookArchive = session.get(RoomBookArchive.class, id);
      if (roomBookArchive == null) {
        throw new FieldNotFoundException("There is no reservation in archive with this name");
      } else {
        return roomBookArchive;
      }
    }
  }

  /**
   * Delete roomBookArchive from DB.
   *
   * @param roomBookArchive - roomBookArchive entity.
   */
  @Override
  public void delete(RoomBookArchive roomBookArchive) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.delete(roomBookArchive);
    }
  }

  /**
   * Edit roomBookArchive in DB.
   *
   * @param roomBookArchive - roomBookArchive entity.
   */
  @Override
  public void edit(RoomBookArchive roomBookArchive) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.update(roomBookArchive);
    }
  }
}
