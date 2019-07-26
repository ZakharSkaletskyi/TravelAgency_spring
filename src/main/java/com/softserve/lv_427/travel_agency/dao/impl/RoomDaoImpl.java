package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.RoomDao;
import com.softserve.lv_427.travel_agency.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDaoImpl implements RoomDao {
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void add(Room room) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(room);
  }

  @Override
  public Room getById(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Room.class, id);
  }

  @Override
  public void delete(Room room) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(room);
  }

  @Override
  public void edit(Room room) {
    Session session = sessionFactory.getCurrentSession();
    session.update(room);
  }
}
