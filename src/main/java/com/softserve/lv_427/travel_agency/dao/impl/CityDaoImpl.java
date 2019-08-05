package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.CityDao;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import com.softserve.lv_427.travel_agency.exception.FieldNotFoundException;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO implementation for City entity.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
@Repository
public class CityDaoImpl implements CityDao {
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Add City to DB.
   *
   * @param city City entity.
   */
  @Override
  public void add(City city) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(city);
  }

  /**
   * Get City from DB by id.
   *
   * @param id id of City.
   * @return city entity of city.
   */
  @Override
  public City getById(int id) {
    try (Session session = sessionFactory.openSession()) {
      City city = session.get(City.class, id);

      if (city == null) {
        throw new FieldNotFoundException("There is no city with this name");
      }

      return city;
    }
  }

  /**
   * Delete City from DB.
   *
   * @param city entity of City.
   */
  @Override
  public void delete(City city) {
    try (Session session = sessionFactory.openSession()) {
      session.delete(city);
    }
  }

  /**
   * Edit City in DB.
   *
   * @param city entity of City.
   */
  @Override
  public void edit(City city) {
    try (Session session = sessionFactory.openSession()) {
      session.update(city);
    }
  }

  /**
   * Find all cities in DB.
   *
   * @return List of City, all cities from DB.
   */
  @Override
  public List<City> findAll() {
    try (Session session = sessionFactory.openSession()) {
      List<City> cities = session.createQuery("from City", City.class).list();

      if (cities == null) {
        throw new FieldNotFoundException("There is no cities");
      }

      return cities;
    }
  }

  /**
   * Find all cities with available hotels on dates in country.
   *
   * @param countryId country id.
   * @param startDate start date of searching.
   * @param endDate end date of searching.
   * @return List of cities.
   */
  @Override
  public List<City> getCitiesWithAvailableHotels(int countryId, String startDate, String endDate) {
    try (Session session = sessionFactory.openSession()) {
      List<Integer> roomIds =
          session
              .createQuery(
                  "SELECT room.id FROM RoomBook"
                      + " WHERE ((orderStart > ?1 AND orderStart < ?2)"
                      + " OR (orderStart < ?3 AND orderEnd > ?4)"
                      + " OR (orderEnd > ?5 AND orderEnd < ?6))",
                  Integer.class)
              .setParameter(1, startDate)
              .setParameter(2, endDate)
              .setParameter(3, startDate)
              .setParameter(4, endDate)
              .setParameter(5, startDate)
              .setParameter(6, endDate)
              .list();

      List<Integer> hotelIds =
          session
              .createQuery(
                  "SELECT distinct hotel.id FROM Room WHERE id NOT IN (:roomIds)", Integer.class)
              .setParameterList("roomIds", roomIds)
              .list();

      List<Integer> cityIds =
          session
              .createQuery(
                  "SELECT distinct city.id from Hotel WHERE id IN (:hotelIds)", Integer.class)
              .setParameterList("hotelIds", hotelIds)
              .list();

      List<City> cities =
          session
              .createQuery("from City where country.id = ?1 AND id IN (:cityIds)", City.class)
              .setParameter(1, countryId)
              .setParameterList("cityIds", cityIds)
              .list();

      if (cities == null) {
        throw new FieldNotFoundException(
            "There is no cities in this country with available hotels");
      }

      return cities;
    }
  }

  /**
   * Find all hotels in city.
   *
   * @param cityId city id.
   * @return List of hotels.
   */
  @Override
  public List<Hotel> getHotels(int cityId) {
    try (Session session = sessionFactory.openSession()) {
      City city = session.get(City.class, cityId);
      Hibernate.initialize(city.getHotels());
      List<Hotel> hotels = city.getHotels();

      if (hotels == null) {
        throw new FieldNotFoundException("There is no hotels in this city, yet");
      }

      return hotels;
    }
  }

  //  @Override
  //  public int getId(String cityName) {
  //    Session session = sessionFactory.getCurrentSession();
  //    return session
  //        .createQuery("Select id from City where name = ?1", Integer.class)
  //        .setParameter(1, cityName)
  //        .uniqueResult();
  //  }
}
