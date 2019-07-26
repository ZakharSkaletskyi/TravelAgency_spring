package com.softserve.lv_427.travel_agency.dao;

import com.softserve.lv_427.travel_agency.entity.RoomBook;

public interface RoomBookDao {
  void add(RoomBook roomBook);

  RoomBook getById(int id);

  void delete(RoomBook roomBook);

  void edit(RoomBook roomBook);
}
