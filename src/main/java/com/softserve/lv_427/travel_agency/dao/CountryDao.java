package com.softserve.lv_427.travel_agency.dao;

import java.util.List;

import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Country;

public interface CountryDao {

  List<City> test(int id);

  Country getById(int id);

  void add(Country country);
}
