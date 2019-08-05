package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.ClientDao;
import com.softserve.lv_427.travel_agency.dao.CountryDao;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.exception.FieldNotFoundException;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DAO implementation for Country entity.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
@Repository
public class CountryDaoImpl implements CountryDao {
  private final SessionFactory sessionFactory;
  private final ClientDao clientDao;

  @Autowired
  public CountryDaoImpl(SessionFactory sessionFactory, ClientDao clientDao) {
    this.sessionFactory = sessionFactory;
    this.clientDao = clientDao;
  }

  /**
   * Add country to DB.
   *
   * @param country Country entity.
   */
  @Override
  public void add(Country country) {
    try (Session session = sessionFactory.openSession()) {
      session.persist(country);
    }
  }

  /**
   * Get country from DB by id.
   *
   * @param id country id.
   * @return Country entity.
   */
  @Override
  public Country getById(int id) {
    try (Session session = sessionFactory.openSession()) {
      Country country = session.get(Country.class, id);

      if (country == null) {
        throw new FieldNotFoundException("There is no country with this name");
      }

      return country;
    }
  }

  /**
   * Delete country from DB.
   *
   * @param country country entity.
   */
  @Override
  public void delete(Country country) {
    try (Session session = sessionFactory.openSession()) {
      session.delete(country);
    }
  }

  /**
   * Edit country in DB.
   *
   * @param country country entity.
   */
  @Override
  public void edit(Country country) {
    try (Session session = sessionFactory.openSession()) {
      session.update(country);
    }
  }

  /**
   * Get all countries from DB.
   *
   * @return List of Countries.
   */
  @Override
  public List<Country> findAll() {
    try (Session session = sessionFactory.openSession()) {
      List<Country> countries = session.createQuery("from Country", Country.class).list();

      if (countries == null) {
        throw new FieldNotFoundException("There is no countries");
      }

      return countries;
    }
  }

  /**
   * Get countries visited by client.
   *
   * @param clientId client id.
   * @return List of Countries
   */
  @Override
  public List<Country> getVisitedCountries(int clientId) {
    try (Session session = sessionFactory.openSession()) {
      Client client = session.get(Client.class, clientId);
      Hibernate.initialize(client.getCountries());

      return client.getCountries();
    }
  }

  /**
   * Get all cities in the country.
   *
   * @param id country id.
   * @return List of Cities
   */
  @Override
  public List<City> getCitiesByCountryId(int id) {
    try (Session session = sessionFactory.openSession()) {
      Country country = session.get(Country.class, id);
      Hibernate.initialize(country.getCities());
      List<City> cities = country.getCities();

      if (cities == null) {
        throw new FieldNotFoundException("There is no cities in this country");
      }

      return cities;
    }
  }

  //  @Override
  //  public int getId(String countryName) {
  //    Session session = sessionFactory.getCurrentSession();
  //    return (Integer)
  //        session
  //            .createQuery("Select id from Country where name = ?1")
  //            .setParameter(1, countryName)
  //            .uniqueResult();
  //  }
}
