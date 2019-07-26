package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.AutoPopulateDB;
import com.softserve.lv_427.travel_agency.service.impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;

@Controller
public class TestController {
  final AutoPopulateDB service;
  final CountryServiceImpl countryService;

  @Autowired
  public TestController(
      AutoPopulateDB service, CountryServiceImpl countryService) {
    this.service = service;
    this.countryService = countryService;
  }

  @RequestMapping(value = "/populate", method = RequestMethod.GET)
  public void mainPage() throws ParseException {
    service.populate();
  }
}
