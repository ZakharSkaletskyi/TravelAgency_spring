package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.CityDao;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

  @Override
  public List<City> findAll() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("from City", City.class).list();
  }

  @Override
  public List<City> getCitiesWithAvailableHotels(int countryId, String startDate, String endDate) {
    Session session = sessionFactory.getCurrentSession();

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

    return session
        .createQuery(
            "from City where country.id = ?1 AND id IN (:cityIds)", City.class)
        .setParameter(1, countryId)
        .setParameterList("cityIds", cityIds)
        .list();
  }

  @Override
  public int getId(String cityName) {
    Session session = sessionFactory.getCurrentSession();
    return session
        .createQuery("Select id from City where name = ?1", Integer.class)
        .setParameter(1, cityName)
        .uniqueResult();
  }

  @Override
  public List<Hotel> getHotels(int cityId) {
    Session session = sessionFactory.getCurrentSession();
    City city = session.get(City.class, cityId);
    Hibernate.initialize(city.getHotels());
    return city.getHotels();
  }
}
