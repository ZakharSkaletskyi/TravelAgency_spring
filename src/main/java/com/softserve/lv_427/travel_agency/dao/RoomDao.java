package com.softserve.lv_427.travel_agency.dao;

import com.softserve.lv_427.travel_agency.entity.Room;

import java.util.Date;
import java.util.List;

public interface RoomDao {
  void add(Room room);

  Room getById(int id);

  void delete(Room room);

  void edit(Room room);

  List<Room> getAvailableRoomsOnDateInHotel(Date startDate, Date endDate, int hotelId);

  int getId(int number, int hotelId);

  int getLoadingRoomsPeriod(String startDate, String endDate, int roomId);

  int getRoomCount(int hotelId);

  int[] get3Int(String s);

  int getDaysFromPeriod(String dateStart, String dateEnd);
}
