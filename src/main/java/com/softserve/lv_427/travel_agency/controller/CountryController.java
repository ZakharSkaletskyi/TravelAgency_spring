package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.dto.CountryDto;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/country")
public class CountryController {
  private final CountryService countryService;

  @Autowired
  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping
  public ModelAndView getCountry(@RequestParam String name) {
    ModelAndView modelAndView = new ModelAndView();
      CountryDto countryDto = countryService.getCountryDto(name);

    modelAndView.addObject("country", countryDto);
    modelAndView.setViewName("country");

    return modelAndView;
  }

  @GetMapping(value = "/all")
  public ModelAndView getAllCountries() {
    ModelAndView modelAndView = new ModelAndView();
    List<Country> countries = countryService.findAll();

    modelAndView.addObject("countries", countries);
    modelAndView.setViewName("countries");

    return modelAndView;
  }
}
