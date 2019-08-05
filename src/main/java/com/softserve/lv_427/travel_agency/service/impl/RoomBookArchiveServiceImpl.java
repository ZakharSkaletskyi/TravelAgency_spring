package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.impl.RoomBookArchiveDaoImpl;
import com.softserve.lv_427.travel_agency.entity.RoomBookArchive;
import com.softserve.lv_427.travel_agency.service.RoomBookArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * Service for RoomBookArchive using RoomBookArchiveDao.
 *
 * @author Agarkov Oleksandr
 * @version 1.0
 */
@Service
public class RoomBookArchiveServiceImpl implements RoomBookArchiveService {
  private final RoomBookArchiveDaoImpl dao;

  @Autowired
  public RoomBookArchiveServiceImpl(RoomBookArchiveDaoImpl dao) {
    this.dao = dao;
  }

  /**
   * Add passed booking to DB.
   *
   * @param roomBookArchive RoomBookArchive entity.
   */
  @Override
  @Transactional
  public void add(RoomBookArchive roomBookArchive) {
    dao.add(roomBookArchive);
  }

  /**
   * Get passed booking from DB by id.
   *
   * @param id booking id.
   * @return RoomBookArchive entity.
   */
  @Override
  @Transactional
  public RoomBookArchive getById(int id) {
    return dao.getById(id);
  }

  /**
   * Delete passed booking from DB.
   *
   * @param roomBookArchive RoomBookArchive entity.
   */
  @Override
  @Transactional
  public void delete(RoomBookArchive roomBookArchive) {
    dao.delete(roomBookArchive);
  }

  /**
   * Edit passed booking from DB.
   *
   * @param roomBookArchive RoomBookArchive entity.
   */
  @Override
  @Transactional
  public void edit(RoomBookArchive roomBookArchive) {
    dao.edit(roomBookArchive);
  }
}
