package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.impl.*;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.entity.Visa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;

@Service
public class AutoPopulateDB {
  final CityDaoImpl cityDao;
  final ClientDaoImpl clientDao;
  final CountryDaoImpl countryDao;
  final HotelDaoImpl hotelDao;
  final RoomBookArchiveDaoImpl roomBookArchiveDao;
  final RoomBookDaoImpl roomBookDao;
  final RoomDaoImpl roomDao;
  final VisaDaoImpl visaDao;

  @Autowired
  public AutoPopulateDB(
      CityDaoImpl cityDao,
      ClientDaoImpl clientDao,
      CountryDaoImpl countryDao,
      HotelDaoImpl hotelDao,
      RoomBookArchiveDaoImpl roomBookArchiveDao,
      RoomBookDaoImpl roomBookDao,
      RoomDaoImpl roomDao,
      VisaDaoImpl visaDao) {
    this.cityDao = cityDao;
    this.clientDao = clientDao;
    this.countryDao = countryDao;
    this.hotelDao = hotelDao;
    this.roomBookArchiveDao = roomBookArchiveDao;
    this.roomBookDao = roomBookDao;
    this.roomDao = roomDao;
    this.visaDao = visaDao;
  }

  @Transactional
  public void populate() {

    Visa jq = new Visa();
    jq.setVisaName("J Q");
    Visa britishTourist = new Visa();
    britishTourist.setVisaName("British tourist");

    Country usa = new Country();
    usa.setCountryName("USA");
    usa.setVisa(jq);
    Country england = new Country();
    england.setCountryName("England");
    england.setVisa(britishTourist);

    City tennessee = new City();
    tennessee.setCityName("Tennessee");
    tennessee.setCountry(usa);
    City lasVegas = new City();
    lasVegas.setCityName("Las Vegas");
    lasVegas.setCountry(usa);
    City london = new City();
    london.setCityName("London");
    london.setCountry(england);
    City cambridge = new City();
    cambridge.setCityName("Cambridge");
    cambridge.setCountry(england);

    usa.setCities(Arrays.asList(tennessee, lasVegas));
    england.setCities(Arrays.asList(london, cambridge));

    jq.setCountries(Collections.singletonList(usa));
    britishTourist.setCountries(Collections.singletonList(england));

    visaDao.add(jq);
    visaDao.add(britishTourist);

    countryDao.add(usa);
    countryDao.add(england);

    cityDao.add(tennessee);
    cityDao.add(lasVegas);
    cityDao.add(london);
    cityDao.add(cambridge);
  }
}
