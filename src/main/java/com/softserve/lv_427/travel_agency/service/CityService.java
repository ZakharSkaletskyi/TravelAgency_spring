package com.softserve.lv_427.travel_agency.service;

import com.softserve.lv_427.travel_agency.dto.CityDto;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Hotel;

import java.util.List;

public interface CityService {
  void add(City city);

  City getById(int id);

  void delete(City city);

  void edit(City city);

  List<City> findAll();

  List<City> getCitiesWithAvailableHotels(int countryId, String startDate, String endDate);

  List<Hotel> getHotels(int cityId);

  CityDto getCityDto(int cityId);

  //  int getId(String cityName);
}
