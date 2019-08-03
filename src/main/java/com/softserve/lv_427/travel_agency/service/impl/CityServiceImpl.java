package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.CityDao;
import com.softserve.lv_427.travel_agency.dto.CityDto;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import com.softserve.lv_427.travel_agency.service.CityService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
  private final CityDao dao;

  @Autowired
  public CityServiceImpl(CityDao dao) {
    this.dao = dao;
  }

  @Override
  @Transactional
  public void add(City city) {
    dao.add(city);
  }

  @Override
  @Transactional
  public City getById(int id) {
    return dao.getById(id);
  }

  @Override
  @Transactional
  public void delete(City city) {
    dao.delete(city);
  }

  @Override
  @Transactional
  public void edit(City city) {
    dao.edit(city);
  }

  @Override
  @Transactional
  public int getId(String cityName) {
    return dao.getId(cityName);
  }

  @Override
  @Transactional
  public List<City> findAll() {
    return dao.findAll();
  }

  @Override
  @Transactional
  public List<City> getCitiesWithAvailableHotels(int countryId, String startDate, String endDate) {
    return dao.getCitiesWithAvailableHotels(countryId, startDate, endDate);
  }

  @Override
  @Transactional
  public List<Hotel> getHotels(int cityId) {
    return dao.getHotels(cityId);
  }

  @Transactional
  public CityDto getCityDto(int cityId) {
    CityDto dto = new CityDto();
    City city = getById(cityId);

    String countryName = city.getCountry().getName();
    List<Hotel> hotels = getHotels(cityId);

    dto.setName(getById(cityId).getName());
    dto.setCountryName(countryName);
    dto.setHotels(hotels);

    return dto;
  }
}
