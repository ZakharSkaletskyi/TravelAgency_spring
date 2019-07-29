package com.softserve.lv_427.travel_agency.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.lv_427.travel_agency.dao.VisaDao;
import com.softserve.lv_427.travel_agency.entity.Visa;
import com.softserve.lv_427.travel_agency.service.VisaService;

public class VisaServiceImpl implements VisaService {
  private VisaDao dao;

  @Autowired
  public VisaServiceImpl(VisaDao dao) {
    this.dao = dao;
  }

  @Override
  @Transactional
  public int getId(String name) throws SQLException, ClassNotFoundException {
    return dao.getId(name);
  }

  @Override
  @Transactional
  public int getVisasCountForTheClient(int clientId) throws SQLException {
    return dao.getVisasCountForTheClient(clientId);
  }
  
}
