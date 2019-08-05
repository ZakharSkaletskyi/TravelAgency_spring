package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for Country logic.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
@Controller
public class CountryController {
  private final CountryService countryService;

  @Autowired
  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  /** Method that returns all countries. */
  @GetMapping(value = "/countries")
  public String getAllCountries(ModelMap model) {
    model.addAttribute("countries", countryService.findAll());

    return "country/countries";
  }

  /** Method that returns Country by his id. */
  @GetMapping(value = "/country")
  public String getCountry(@RequestParam int id, ModelMap model) {
    model.addAttribute("country", countryService.getCountryDto(id));

    return "country/country";
  }
}
