package com.softserve.lv_427.travel_agency.service;

import com.softserve.lv_427.travel_agency.entity.RoomBook;

public interface RoomBookService {
    void add(RoomBook roomBook);

    RoomBook getById(int id);

    void delete(RoomBook roomBook);

    void edit(RoomBook roomBook);

    void movePastBookingToArchive();
}
