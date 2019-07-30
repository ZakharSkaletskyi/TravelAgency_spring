package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.dto.CityDto;
import com.softserve.lv_427.travel_agency.dto.CountryDto;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.service.CityService;
import com.softserve.lv_427.travel_agency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/city")
public class CityController {
  private final CityService cityService;
  private final CountryService countryService;

  @Autowired
  public CityController(CityService cityService, CountryService countryService) {
    this.cityService = cityService;
    this.countryService = countryService;
  }

  @GetMapping
  public ModelAndView getCity(@RequestParam String name) {
    ModelAndView modelAndView = new ModelAndView();
    CityDto cityDto = cityService.getCityDto(name);

    modelAndView.addObject("city", cityDto);
    modelAndView.setViewName("city");

    return modelAndView;
  }

  @GetMapping(value = "/all")
  public ModelAndView getAllCities() {
    ModelAndView modelAndView = new ModelAndView();
    List<City> cities = cityService.findAll();

    modelAndView.addObject("cities", cities);
    modelAndView.setViewName("cities");

    return modelAndView;
  }
}
