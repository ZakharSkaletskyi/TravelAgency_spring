package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.entity.Visa;
import com.softserve.lv_427.travel_agency.service.AutoPopulateDB;
import com.softserve.lv_427.travel_agency.service.impl.CountryServiceImpl;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.List;

@Controller
public class TestController {
  final AutoPopulateDB service;
  final CountryServiceImpl countryService;

  @Autowired
  public TestController(AutoPopulateDB service, CountryServiceImpl countryService) {
    this.service = service;
    this.countryService = countryService;
  }

  @RequestMapping(value = "/populate", method = RequestMethod.GET)
  public void mainPage() throws ParseException {
    service.populate();
  }

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public void test() {
    List<Country> countries = countryService.findAllCountries();
    int countryId = countryService.getCountryId("USA");
    List<Country> visitedCountries = countryService.getVisitedCountries(2);
    List<City> cities = countryService.getCities(2);



    System.out.println("All good!");
  }
}
