package com.softserve.lv_427.travel_agency.service;

import com.softserve.lv_427.travel_agency.entity.RoomBookArchive;

public interface RoomBookArchiveService {
    void add(RoomBookArchive roomBookArchive);

    RoomBookArchive getById(int id);

    void delete(RoomBookArchive roomBookArchive);

    void edit(RoomBookArchive roomBookArchive);
}
