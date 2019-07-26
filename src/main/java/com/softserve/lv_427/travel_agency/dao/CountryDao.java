package com.softserve.lv_427.travel_agency.dao;

import com.softserve.lv_427.travel_agency.entity.Country;

public interface CountryDao {
  void add(Country country);

  Country getById(int id);

  void delete(Country country);

  void edit(Country country);
}
