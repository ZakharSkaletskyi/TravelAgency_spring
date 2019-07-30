package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.impl.RoomDaoImpl;
import com.softserve.lv_427.travel_agency.entity.Room;
import com.softserve.lv_427.travel_agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
  private final RoomDaoImpl dao;

  @Autowired
  public RoomServiceImpl(RoomDaoImpl dao) {
    this.dao = dao;
  }

  @Override
  @Transactional
  public void add(Room room) {
    dao.add(room);
  }

  @Override
  @Transactional
  public Room getById(int id) {
    return dao.getById(id);
  }

  @Override
  @Transactional
  public void delete(Room room) {
    dao.delete(room);
  }

  @Override
  @Transactional
  public void edit(Room room) {
    dao.edit(room);
  }

  @Override
  @Transactional
  public List<Room> getAvailableRoomsOnDateInHotel(String startDate, String endDate, int hotelId) {
    return dao.getAvailableRoomsOnDateInHotel(startDate, endDate, hotelId);
  }

  @Override
  @Transactional
  public int getLoadingRoomsPeriod(String startDate, String endDate, int roomId) {
    return dao.getLoadingRoomsPeriod(startDate, endDate, roomId);
  }

  @Override
  @Transactional
  public int getRoomCount(int hotelId) {
    return getRoomCount(hotelId);
  }

  @Override
  public int getDaysFromPeriod(String dateStart, String dateEnd) {
    return dao.getDaysFromPeriod(dateStart, dateEnd);
  }
}
