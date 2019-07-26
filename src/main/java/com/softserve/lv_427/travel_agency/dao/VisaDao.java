package com.softserve.lv_427.travel_agency.dao;

import com.softserve.lv_427.travel_agency.entity.Visa;

public interface VisaDao {
  void add(Visa visa);

  Visa getById(int id);

  void delete(Visa visa);

  void edit(Visa visa);
}
