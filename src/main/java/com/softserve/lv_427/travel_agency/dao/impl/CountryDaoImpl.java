package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.ClientDao;
import com.softserve.lv_427.travel_agency.dao.CountryDao;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.entity.Country;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {

  @Autowired private SessionFactory sessionFactory;
  @Autowired private ClientDao clientDao;

  @Override
  public void add(Country country) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(country);
  }

  @Override
  public Country getById(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Country.class, id);
  }

  @Override
  public void delete(Country country) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(country);
  }

  @Override
  public void edit(Country country) {
    Session session = sessionFactory.getCurrentSession();
    session.update(country);
  }

  @Override
  public List<Country> findAll() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("from Country", Country.class).list();
  }

  @Override
  public int getId(String countryName) {
    Session session = sessionFactory.getCurrentSession();
    return (Integer)
        session
            .createQuery("Select id from Country where name = ?1")
            .setParameter(1, countryName)
            .uniqueResult();
  }

  @Override
  public List<Country> getVisitedCountries(int clientId) {
    Client client = clientDao.getById(clientId);
    Hibernate.initialize(client.getCountries());
    return client.getCountries();
  }

  @Override
  public List<City> getCitiesByCountryId(int id) {
    Session session = sessionFactory.getCurrentSession();
    Country country = session.get(Country.class, id);
    Hibernate.initialize(country.getCities());
    return country.getCities();
  }
}
