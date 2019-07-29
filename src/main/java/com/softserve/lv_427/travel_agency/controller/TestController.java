package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.dao.impl.HotelDaoImpl;
import com.softserve.lv_427.travel_agency.entity.*;
import com.softserve.lv_427.travel_agency.service.AutoPopulateDB;
import com.softserve.lv_427.travel_agency.service.RoomBookService;
import com.softserve.lv_427.travel_agency.service.impl.CityServiceImpl;
import com.softserve.lv_427.travel_agency.service.impl.CountryServiceImpl;
import com.softserve.lv_427.travel_agency.service.impl.HotelServiceImpl;
import com.softserve.lv_427.travel_agency.service.impl.RoomBookServiceImpl;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.List;

@Controller
public class TestController {
	 @Autowired private  AutoPopulateDB service;
  @Autowired private  CountryServiceImpl countryService;
  @Autowired private  CityServiceImpl cityService;
  @Autowired private  HotelServiceImpl hotelService;



  @RequestMapping(value = "/populate", method = RequestMethod.GET)
  public void mainPage() throws ParseException {
    service.populate();
  }

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public void test() throws ParseException {
    // test countryService
    //    List<Country> countries = countryService.findAllCountries();
    //    int countryId = countryService.getCountryId("USA");
    //    List<Country> visitedCountries = countryService.getVisitedCountries(2);
    //    List<City> cities = countryService.getCities(2);

    // test cityService
    //    List<City> cities1 = cityService.findAll();

//        List<City> cities2 = cityService.getCityWithAvailableHotels(1, "2019-06-01",
//     "2019-08-28");

    //    int cityId = cityService.getId("London");
    //    List<Hotel> hotels = cityService.getHotels(3);

    // test hotelService

//    List<Hotel> hotels = hotelService.getAll();
//    int id = hotelService.getId("The D");
//    int count = hotelService.getClientCountForPeriod(1, "2019-01-01", "2019-07-05");
//    List<Hotel> hotels = hotelService.getAvailableHotelsOnDates("2019-01-01", "2019-07-05");
//    int avarage = hotelService.getAverageBookTime(1, "2019-01-01", "2019-07-05");

    System.out.println("All good!");
  }
}
