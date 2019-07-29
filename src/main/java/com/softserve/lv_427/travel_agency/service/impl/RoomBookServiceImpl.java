package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.impl.RoomBookDaoImpl;
import com.softserve.lv_427.travel_agency.entity.RoomBook;
import com.softserve.lv_427.travel_agency.service.RoomBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomBookServiceImpl implements RoomBookService {
  final RoomBookDaoImpl dao;

  @Autowired
  public RoomBookServiceImpl(RoomBookDaoImpl dao) {
    this.dao = dao;
  }

  @Override
  @Transactional
  public void add(RoomBook roomBook) {
    dao.add(roomBook);
  }

  @Override
  @Transactional
  public RoomBook getById(int id) {
    return dao.getById(id);
  }

  @Override
  @Transactional
  public void delete(RoomBook roomBook) {
    dao.delete(roomBook);
  }

  @Override
  @Transactional
  public void edit(RoomBook roomBook) {
    dao.delete(roomBook);
  }

  @Override
  @Transactional
  public void managePastBookingToArchive() {
    dao.movePastBookingToArchive();
    dao.deletePastBookingToArchive();
  }
}
