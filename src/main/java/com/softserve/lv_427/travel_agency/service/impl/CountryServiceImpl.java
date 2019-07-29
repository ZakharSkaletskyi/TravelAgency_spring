package com.softserve.lv_427.travel_agency.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.lv_427.travel_agency.dao.impl.CountryDaoImpl;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.service.AutoPopulateDB;
import com.softserve.lv_427.travel_agency.service.CountryService;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
	  final CountryDaoImpl dao;
	  final AutoPopulateDB populateDB;

	  @Autowired
	  public CountryServiceImpl(CountryDaoImpl dao, AutoPopulateDB populateDB) {
	    this.dao = dao;
	    this.populateDB = populateDB;
	  }

  @Override
  @Transactional
  public void add(Country country) {
    dao.add(country);
  }

  @Override
  @Transactional
  public Country getById(int id) {
    return dao.getById(id);
  }

  @Override
  @Transactional
  public void delete(Country country) {
    dao.delete(country);
  }

  @Override
  @Transactional
  public void edit(Country country) {
    dao.edit(country);
  }

  @Override
  @Transactional
  public List<Country> findAll() {
    return dao.findAll();
  }

  @Override
  @Transactional
  public int getId(String countryName) {
    return dao.getId(countryName);
  }

  @Override
  @Transactional
  public List<Country> getVisitedCountries(int clientId) {
    return dao.getVisitedCountries(clientId);
  }

  @Override
  @Transactional
  public List<City> getCitiesByCountryId(int id) {
    return dao.getCitiesByCountryId(id);
  }
}
