package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.HotelDao;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDaoImpl implements HotelDao {
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void add(Hotel hotel) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(hotel);
  }

  @Override
  public Hotel getById(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Hotel.class, id);
  }

  @Override
  public void delete(Hotel hotel) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(hotel);
  }

  @Override
  public void edit(Hotel hotel) {
    Session session = sessionFactory.getCurrentSession();
    session.update(hotel);
  }
}
