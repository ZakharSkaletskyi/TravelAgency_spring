package com.softserve.lv_427.travel_agency.service;

import com.softserve.lv_427.travel_agency.entity.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoomService {
  void add(Room room);

  Room getById(int id);

  void delete(Room room);

  void edit(Room room);

  List<Room> getAvailableRoomsOnDateInHotel(String startDate, String endDate, int hotelId);

  int getLoadingRoomsPeriod(String startDate, String endDate, int roomId);

  int getLoadingPeriod(String startDate, String endDate);

  int getRoomCount(int hotelId);

  int[] loadingRoomsPeriod(String startDate, String endDate, int roomId);

  //  int getDaysFromPeriod(String dateStart, String dateEnd);
}
