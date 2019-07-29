package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.impl.RoomBookArchiveDaoImpl;
import com.softserve.lv_427.travel_agency.entity.RoomBookArchive;
import com.softserve.lv_427.travel_agency.service.RoomBookArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomBookArchiveServiceImpl implements RoomBookArchiveService {
  private final RoomBookArchiveDaoImpl dao;

  @Autowired
  public RoomBookArchiveServiceImpl(RoomBookArchiveDaoImpl dao) {
    this.dao = dao;
  }

  @Override
  @Transactional
  public void add(RoomBookArchive roomBookArchive) {
    dao.add(roomBookArchive);
  }

  @Override
  @Transactional
  public RoomBookArchive getById(int id) {
    return dao.getById(id);
  }

  @Override
  @Transactional
  public void delete(RoomBookArchive roomBookArchive) {
    dao.delete(roomBookArchive);
  }

  @Override
  @Transactional
  public void edit(RoomBookArchive roomBookArchive) {
    dao.edit(roomBookArchive);
  }
}
