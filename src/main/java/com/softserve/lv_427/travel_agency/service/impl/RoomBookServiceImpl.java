package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.impl.RoomBookDaoImpl;
import com.softserve.lv_427.travel_agency.entity.RoomBook;
import com.softserve.lv_427.travel_agency.service.RoomBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.lv_427.travel_agency.dao.impl.RoomDaoImpl;
import com.softserve.lv_427.travel_agency.entity.Room;
import com.softserve.lv_427.travel_agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
/**
 * Service for RoomBook using RoomBookDao.
 *
 * @author Agarkov Oleksandr
 * @version 1.0
 */
@Service
public class RoomBookServiceImpl implements RoomBookService {
  final RoomBookDaoImpl dao;

  @Autowired
  public RoomBookServiceImpl(RoomBookDaoImpl dao) {
    this.dao = dao;
  }

  /**
   * Add booking to DB.
   *
   * @param roomBook RoomBook entity.
   */
  @Override
  @Transactional
  public void add(RoomBook roomBook) {
    dao.add(roomBook);
  }

  /**
   * Get booking from DB by id.
   *
   * @param id booking id.
   * @return RoomBook entity.
   */
  @Override
  @Transactional
  public RoomBook getById(int id) {
    return dao.getById(id);
  }

  /**
   * Delete booking from DB.
   *
   * @param roomBook RoomBook entity.
   */
  @Override
  @Transactional
  public void delete(RoomBook roomBook) {
    dao.delete(roomBook);
  }

  /**
   * Edit booking in DB.
   *
   * @param roomBook RoomBook entity.
   */
  @Override
  @Transactional
  public void edit(RoomBook roomBook) {
    dao.delete(roomBook);
  }

  /** Send the old orders in RoomBookArchive and delete the this.copy in RoomBook */
  @Override
  @Transactional
  public void managePastBookingToArchive() {
    dao.movePastBookingToArchive();
    dao.deletePastBookingToArchive();
  }
}
