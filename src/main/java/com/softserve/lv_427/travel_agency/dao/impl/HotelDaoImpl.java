package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.HotelDao;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import com.softserve.lv_427.travel_agency.entity.Room;
import com.softserve.lv_427.travel_agency.exception.FieldNotFoundException;
import com.softserve.lv_427.travel_agency.service.external.DaysService;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO implementation for City entity.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
@Repository
public class HotelDaoImpl implements HotelDao {
  private SessionFactory sessionFactory;
  private DaysService daysService;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory, DaysService daysService) {
    this.sessionFactory = sessionFactory;
    this.daysService = daysService;
  }

  /**
   * Add Hotel entity to DB.
   *
   * @param hotel - Hotel entity.
   */
  @Override
  public void add(Hotel hotel) {
    try (Session session = sessionFactory.openSession()) {
      session.persist(hotel);
    }
  }

  /**
   * Get hotel from DB by id.
   *
   * @param id - hotel id.
   * @return Hotel entity.
   */
  @Override
  public Hotel getById(int id) {
    try (Session session = sessionFactory.openSession()) {
      Hotel hotel = session.get(Hotel.class, id);

      if (hotel == null) {
        throw new FieldNotFoundException("There is no hotel with this name");
      } else {
        return hotel;
      }
    }
  }

  /**
   * Delete hotel from DB.
   *
   * @param hotel - hotel entity.
   */
  @Override
  public void delete(Hotel hotel) {
    try (Session session = sessionFactory.openSession()) {
      session.delete(hotel);
    }
  }

  /**
   * Edit hotel in DB.
   *
   * @param hotel - hotel entity.
   */
  @Override
  public void edit(Hotel hotel) {
    try (Session session = sessionFactory.openSession()) {
      session.update(hotel);
    }
  }

  /**
   * Get all hotels from DB.
   *
   * @return List of Hotels.
   */
  @Override
  public List<Hotel> getAll() {
    try (Session session = sessionFactory.openSession()) {
      List<Hotel> hotels = session.createQuery("FROM Hotel", Hotel.class).list();

      if (hotels == null) {
        throw new FieldNotFoundException("There is no hotels");
      } else {
        return hotels;
      }
    }
  }

  /**
   * Get count of clients on period in hotel.
   *
   * @param hotelId - hotel id.
   * @param dateStart - start date.
   * @param dateEnd - end date
   * @return int - count of clients.
   */
  @Override
  public int getClientCountForPeriod(int hotelId, String dateStart, String dateEnd) {
    try (Session session = sessionFactory.openSession()) {
      List<Integer> roomIds =
          session
              .createQuery("SELECT id FROM Room where hotel.id = ?1", Integer.class)
              .setParameter(1, hotelId)
              .list();

      return session
          .createQuery(
              "SELECT COUNT(client.id) FROM RoomBookArchive WHERE (orderStart >= ?1 AND orderEnd <= ?2 AND room.id IN (:roomIds))",
              Long.class)
          .setParameter(1, dateStart)
          .setParameter(2, dateEnd)
          .setParameterList("roomIds", roomIds)
          .uniqueResult()
          .intValue();
    }
  }

  /**
   * Get all available hotels no period.
   *
   * @param dateStart - start date.
   * @param dateEnd - end date
   * @return List of hotels.
   */
  @Override
  public List<Hotel> getAvailableHotelsOnDates(String dateStart, String dateEnd) {
    try (Session session = sessionFactory.openSession()) {
      List<Integer> roomIds =
          session
              .createQuery(
                  "SELECT room.id FROM RoomBook"
                      + " WHERE ((orderStart > ?1 AND orderStart < ?2)"
                      + " OR (orderStart < ?1 AND orderEnd > ?2)"
                      + " OR (orderEnd > ?1 AND orderEnd < ?2))",
                  Integer.class)
              .setParameter(1, dateStart)
              .setParameter(2, dateEnd)
              .list();

      List<Integer> hotelIds =
          session
              .createQuery(
                  "SELECT distinct hotel.id FROM Room WHERE id NOT IN (:roomIds)", Integer.class)
              .setParameterList("roomIds", roomIds)
              .list();

      List<Hotel> availableHotels =
          session
              .createQuery("from Hotel where id IN (:hotelIds)", Hotel.class)
              .setParameterList("hotelIds", hotelIds)
              .list();

      if (availableHotels == null) {
        throw new FieldNotFoundException("There is no available hotels in this city");
      } else {
        return availableHotels;
      }
    }
  }

  /**
   * Get average book time in hotel on period.
   *
   * @param hotelId - hotel id.
   * @param dateStart - start date.
   * @param dateEnd - end date
   * @return average book time in days.
   */
  @Override
  public int getAverageBookTime(int hotelId, String dateStart, String dateEnd) {
    try (Session session = sessionFactory.openSession()) {
      List<Object[]> bookDaysArchive =
          new ArrayList<>(
              session
                  .createQuery(
                      "SELECT orderStart, orderEnd FROM RoomBookArchive WHERE "
                          + "(orderStart >= ?1  AND orderEnd <= ?2 AND room.id IN "
                          + "(SELECT id FROM Room where hotel.id = ?3))",
                      Object[].class)
                  .setParameter(1, dateStart)
                  .setParameter(2, dateEnd)
                  .setParameter(3, hotelId)
                  .list());

      List<Integer> bookDays = new ArrayList<>();
      for (Object[] date : bookDaysArchive) {
        bookDays.add(daysService.getDaysFromPeriod((String) date[0], (String) date[1]));
      }

      return bookDays.size() > 0
          ? bookDays.stream().mapToInt(Integer::intValue).sum() / bookDays.size()
          : 0;
    }
  }

  /**
   * Get rooms in hotel.
   *
   * @param hotelId - hotel id.
   * @return List of rooms.
   */
  @Override
  public List<Room> getRoomsByHotel(int hotelId) {
    try (Session session = sessionFactory.openSession()) {
      Hotel hotel = session.get(Hotel.class, hotelId);
      Hibernate.initialize(hotel.getRooms());
      List<Room> rooms = hotel.getRooms();

      if (rooms == null) {
        throw new FieldNotFoundException("There is no rooms in this hotel");
      } else {
        return rooms;
      }
    }
  }

  //  @Override
  //  public int getId(String name) {
  //    Session session = sessionFactory.getCurrentSession();
  //    return session
  //        .createQuery("Select id from Hotel where name = ?1", Integer.class)
  //        .setParameter(1, name)
  //        .uniqueResult();
  //  }
}
