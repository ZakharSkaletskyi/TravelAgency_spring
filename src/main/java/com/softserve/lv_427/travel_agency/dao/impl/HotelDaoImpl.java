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
                      + " OR (orderStart < ?3 AND orderEnd > ?4)"
                      + " OR (orderEnd > ?5 AND orderEnd < ?6))",
                  Integer.class)
              .setParameter(1, dateStart)
              .setParameter(2, dateEnd)
              .setParameter(3, dateStart)
              .setParameter(4, dateEnd)
              .setParameter(5, dateStart)
              .setParameter(6, dateEnd)
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
   * Get hotels with available rooms in city.
   *
   * @param cityId - city id.
   * @param startDate - start date.
   * @param endDate - end date.
   * @return List of hotels.
   */
  @Override
  public List<Hotel> getAvailableHotelsOnDatesInCity(int cityId, String startDate, String endDate) {
    try (Session session = sessionFactory.openSession()) {
      List<Hotel> hotels;
      List<Integer> bookedHotelsRooms =
          session
              .createQuery(
                  "SELECT r.id FROM City c JOIN c.hotels h JOIN h.rooms r LEFT JOIN r.roomBooks rb WHERE "
                      + "(c.id= ?1 "
                      + "AND ((rb.orderStart > ?2 AND rb.orderStart < ?3)"
                      + " OR (rb.orderStart < ?2 AND rb.orderEnd > ?3)"
                      + " OR (rb.orderEnd > ?2 AND rb.orderEnd < ?3)))",
                  Integer.class)
              .setParameter(1, cityId)
              .setParameter(2, startDate)
              .setParameter(3, endDate)
              .list();

      if (bookedHotelsRooms.size() == 0) {
        hotels =
            session
                .createQuery(
                    "SELECT h FROM City c JOIN c.hotels h JOIN h.rooms r WHERE c.id= ?1 ",
                    Hotel.class)
                .setParameter(1, cityId)
                .list();
      } else {
        hotels =
            session
                .createQuery(
                    "SELECT h FROM City c JOIN c.hotels h WHERE c.id= ?1 AND h.id NOT IN (:bookedHotelsRooms) ",
                    Hotel.class)
                .setParameter(1, cityId)
                .setParameterList("bookedHotelsRooms", bookedHotelsRooms)
                .list();
      }
      if (hotels == null) {
        throw new FieldNotFoundException("In DB no available countries for clientId= " + cityId);
      }
      return hotels;
    }
  }

  /**
   * Get all rooms in hotel.
   *
   * @param hotelId - hotel id.
   * @return List of rooms.
   */
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
}
