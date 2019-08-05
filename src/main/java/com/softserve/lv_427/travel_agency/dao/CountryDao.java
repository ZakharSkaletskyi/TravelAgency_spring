package com.softserve.lv_427.travel_agency.dao;

import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Country;

import java.util.List;

public interface CountryDao {
  void add(Country country);

  Country getById(int id);

  void delete(Country country);

  void edit(Country country);

  List<Country> getVisitedCountries(int clientId);

  List<City> getCitiesByCountryId(int id);

  List<Country> findAll();

  //  int getId(String countryName);
}