package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.impl.RoomBookArchiveDaoImpl;
import com.softserve.lv_427.travel_agency.entity.RoomBookArchive;
import com.softserve.lv_427.travel_agency.service.RoomBookArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomBookArchiveServiceImpl implements RoomBookArchiveService {
  private final RoomBookArchiveDaoImpl dao;

  @Autowired
  public RoomBookArchiveServiceImpl(RoomBookArchiveDaoImpl dao) {
    this.dao = dao;
  }

  @Override
  public void add(RoomBookArchive roomBookArchive) {
    dao.add(roomBookArchive);
  }

  @Override
  public RoomBookArchive getById(int id) {
    return dao.getById(id);
  }

  @Override
  public void delete(RoomBookArchive roomBookArchive) {
    dao.delete(roomBookArchive);
  }

  @Override
  public void edit(RoomBookArchive roomBookArchive) {
    dao.edit(roomBookArchive);
  }
}
