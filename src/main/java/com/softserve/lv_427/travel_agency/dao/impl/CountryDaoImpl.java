package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl {
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public void add(Country country) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(country);
  }

  public Country getById(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Country.class, id);
  }


  public Country test(int id) {
    Session session = sessionFactory.getCurrentSession();
    List<City> cities = session.get(Country.class, id).getCities();
    return new Country();
  }
}
