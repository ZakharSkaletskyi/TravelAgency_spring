package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.impl.CountryDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryServiceImpl {
  final CountryDaoImpl dao;
  final AutoPopulateDB populateDB;

  @Autowired
  public CountryServiceImpl(CountryDaoImpl dao, AutoPopulateDB populateDB) {
    this.dao = dao;
    this.populateDB = populateDB;
  }

//  @Transactional
//  public void get() {
//    populateDB.populate();
////    Country country = dao.test(1);
//   // System.out.println(country);
//  }
}
