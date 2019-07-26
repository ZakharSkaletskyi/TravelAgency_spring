package com.softserve.lv_427.travel_agency.dao;

import com.softserve.lv_427.travel_agency.entity.Room;

public interface RoomDao {
  void add(Room room);

  Room getById(int id);

  void delete(Room room);

  void edit(Room room);
}
