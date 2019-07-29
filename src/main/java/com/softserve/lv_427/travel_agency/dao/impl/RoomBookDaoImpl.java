package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.RoomBookDao;
import com.softserve.lv_427.travel_agency.entity.RoomBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

  }
}
