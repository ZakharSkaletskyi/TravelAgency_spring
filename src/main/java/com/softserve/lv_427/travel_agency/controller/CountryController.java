package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/country")
public class CountryController {
  private final CountryService countryService;

  @Autowired
  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping
  public String getAllCountries(ModelMap model) {
    model.addAttribute("countries", countryService.findAll());

    return "countries";
  }

  @PostMapping
  public String getCountry(@RequestParam int countryId, ModelMap model) {
    model.addAttribute("country", countryService.getCountryDto(countryId));

    return "country";
  }
}
