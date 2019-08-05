package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.impl.RoomDaoImpl;
import com.softserve.lv_427.travel_agency.entity.Room;
import com.softserve.lv_427.travel_agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
/**
 * Service for Room using RoomDao.
 *
 * @author Agarkov Oleksandr
 * @version 1.0
 */
@Service
public class RoomServiceImpl implements RoomService {
  private final RoomDaoImpl dao;

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

  /**
   * Get the count of days in certain period
   *
   * @param dateStart - start date.
   * @param dateEnd - end date
   * @return the count of days in certain period.
   */
  @Override
  public int getDaysFromPeriod(String dateStart, String dateEnd) {
    return dao.getDaysFromPeriod(dateStart, dateEnd);
  }
}
