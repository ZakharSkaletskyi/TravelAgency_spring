package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.external.AutoPopulateDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;

@Controller
public class TestController {
  private final AutoPopulateDB service;

  @Autowired
  public TestController(AutoPopulateDB service) {
    this.service = service;
  }

  @RequestMapping(value = "/populate", method = RequestMethod.GET)
  public void mainPage() throws ParseException {
    service.populate();
  }
}