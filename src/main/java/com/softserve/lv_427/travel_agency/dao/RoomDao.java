package com.softserve.lv_427.travel_agency.dao;

import com.softserve.lv_427.travel_agency.entity.Room;

import java.util.List;

public interface RoomDao {
  void add(Room room);

  Room getById(int id);

  void delete(Room room);

  void edit(Room room);

  List<Room> getAvailableRoomsOnDateInHotel(String startDate, String endDate, int hotelId);

  int getLoadingRoomsPeriod(String startDate, String endDate, int roomId);

  int getRoomCount(int hotelId);
}
