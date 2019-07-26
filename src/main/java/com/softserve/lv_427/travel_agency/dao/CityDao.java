package com.softserve.lv_427.travel_agency.dao;

import com.softserve.lv_427.travel_agency.entity.City;

public interface CityDao {
  void add(City city);

  City getById(int id);

  void delete(City city);

  void edit(City city);
}
