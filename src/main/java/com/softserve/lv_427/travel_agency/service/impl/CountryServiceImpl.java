package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.impl.CountryDaoImpl;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.entity.Visa;
import com.softserve.lv_427.travel_agency.service.AutoPopulateDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.zip.CheckedOutputStream;

@Service
public class CountryServiceImpl {
  final CountryDaoImpl dao;
  final AutoPopulateDB populateDB;

  @Autowired
  public CountryServiceImpl(CountryDaoImpl dao, AutoPopulateDB populateDB) {
    this.dao = dao;
    this.populateDB = populateDB;
  }

  @Transactional
  public Country getById(int id) {
    return dao.getById(id);
  }

  //  @Transactional
  //  public List<City> getCitiesByCountryId(int id) {
  //    return dao.getCitiesByCountryId(id);
  //  }

  //  @Transactional
  //  public Visa getVisaByCountryId(int id) {
  //    return dao.getVisaByCountryId(id);
  //  }

  @Transactional
  public List<Country> findAllCountries() {
    return dao.findAll();
  }

  @Transactional
  public List<Country> visitedCountries(int clientId) {
    return dao.getVisitedCountries(clientId);
  }

  @Transactional
  public int getCountryId(String countryName) {
    return dao.getId(countryName);
  }

  @Transactional
  public List<Country> getVisitedCountries(int clientId) {
    return dao.getVisitedCountries(clientId);
  }

  @Transactional
  public List<City> getCities(int countryId) {
    return dao.getCitiesByCountryId(countryId);
  }

}
