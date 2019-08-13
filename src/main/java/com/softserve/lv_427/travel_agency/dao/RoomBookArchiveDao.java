package com.softserve.lv_427.travel_agency.dao;

import com.softserve.lv_427.travel_agency.entity.RoomBookArchive;

public interface RoomBookArchiveDao {
  void add(RoomBookArchive roomBookArchive);

  RoomBookArchive getById(int id);

  void delete(RoomBookArchive roomBookArchive);

  void edit(RoomBookArchive roomBookArchive);
}
