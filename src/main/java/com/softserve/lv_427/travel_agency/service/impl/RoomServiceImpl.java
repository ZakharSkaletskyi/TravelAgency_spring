package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.RoomDao;
import com.softserve.lv_427.travel_agency.dao.impl.RoomDaoImpl;
import com.softserve.lv_427.travel_agency.entity.Room;
import com.softserve.lv_427.travel_agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Service for Room using RoomDao.
 *
 * @author Agarkov Oleksandr
 * @version 1.0
 */
@Service
public class RoomServiceImpl implements RoomService {
  private final RoomDao dao;

  @Autowired
  public RoomServiceImpl(RoomDaoImpl dao) {
    this.dao = dao;
  }

  /**
   * Add room to DB.
   *
   * @param room Room entity.
   */
  @Override
  @Transactional
  public void add(Room room) {
    dao.add(room);
  }

  /**
   * Get room from DB by id.
   *
   * @param id room id.
   * @return Room entity.
   */
  @Override
  @Transactional
  public Room getById(int id) {
    return dao.getById(id);
  }

  /**
   * Delete room from DB.
   *
   * @param room Room entity.
   */
  @Override
  @Transactional
  public void delete(Room room) {
    dao.delete(room);
  }

  /**
   * Edit room in DB.
   *
   * @param room Room entity.
   */
  @Override
  @Transactional
  public void edit(Room room) {
    dao.edit(room);
  }

  /**
   * Get all available rooms in hotel in certain period.
   *
   * @param startDate - start date.
   * @param endDate - end date
   * @param hotelId - id hotel
   * @return List of rooms.
   */
  @Override
  @Transactional
  public List<Room> getAvailableRoomsOnDateInHotel(String startDate, String endDate, int hotelId) {
    return dao.getAvailableRoomsOnDateInHotel(startDate, endDate, hotelId);
  }

  /**
   * Get the loading of room in certain period.
   *
   * @param startDate - start date.
   * @param endDate - end date
   * @param roomId - id room
   * @return loading of room in days.
   */
  @Override
  @Transactional
  public int getLoadingRoomsPeriod(String startDate, String endDate, int roomId) {
    return dao.getLoadingRoomsPeriod(startDate, endDate, roomId);
  }

  /**
   * Get the loading of room in certain period.
   *
   * @param startDate - start date.
   * @param endDate - end date
   * @param roomId - id room
   * @return array with rooms loading in days and loading period.
   */
  @Override
  @Transactional
  public int[] loadingRoomsPeriod(String startDate, String endDate, int roomId) {
    int[] loading = new int[2];
    loading[0] = dao.getLoadingRoomsPeriod(startDate, endDate, roomId);
    loading[1] = getLoadingPeriod(startDate, endDate);
    return loading;
  }

  /**
   * Get the loading period(difference between start and end date).
   *
   * @param startDate - start date.
   * @param endDate - end date
   * @return count of days.
   */
  @Override
  @Transactional
  public int getLoadingPeriod(String startDate, String endDate) {
      SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
      Long periodL = null;

      try {
          Date date1 = myFormat.parse(startDate);
          Date date2 = myFormat.parse(endDate);
          Long diff = date2.getTime() - date1.getTime();
          periodL = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
      } catch (ParseException e) {
          e.printStackTrace();
      }

      return periodL.intValue();
  }

  /**
   * Get the count of room in certain hotel.
   *
   * @param hotelId - id hotel
   * @return the count of room in certain hotel.
   */
  @Override
  @Transactional
  public int getRoomCount(int hotelId) {
    return dao.getRoomCount(hotelId);
  }

//  @Override
//  public int getDaysFromPeriod(String dateStart, String dateEnd) {
//    return dao.getDaysFromPeriod(dateStart, dateEnd);
//  }
}
