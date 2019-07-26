package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.CityDao;
import com.softserve.lv_427.travel_agency.entity.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDaoImpl implements CityDao {
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void add(City city) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(city);
  }

  @Override
  public City getById(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(City.class, id);
  }

  @Override
  public void delete(City city) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(city);
  }

  @Override
  public void edit(City city) {
    Session session = sessionFactory.getCurrentSession();
    session.update(city);
  }
}
