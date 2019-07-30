package com.softserve.lv_427.travel_agency.service;

import com.softserve.lv_427.travel_agency.dto.CountryDto;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Country;

import java.util.List;

public interface CountryService {
  void add(Country country);

  Country getById(int id);

  void delete(Country country);

  void edit(Country country);

  List<Country> findAll();

  int getId(String countryName);

  List<Country> getVisitedCountries(int clientId);

  List<City> getCitiesByCountryId(int id);

  CountryDto getCountryDto(int countryId);
}
