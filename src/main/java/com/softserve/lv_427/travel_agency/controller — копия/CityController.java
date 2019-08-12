package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for City logic.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
@Controller
public class CityController {
  private final CityService cityService;

  @Autowired
  public CityController(CityService cityService) {
    this.cityService = cityService;
  }

  /** Method that returns all cities. */
  @GetMapping(value = "/cities")
  public String getAllCities(ModelMap model) {
    model.addAttribute("cities", cityService.findAll());

    return "city/cities";
  }

  /** Method that returns City by his id. */
  @GetMapping(value = "/city")
  public String getCity(@RequestParam int id, ModelMap model) {
    model.addAttribute("city", cityService.getCityDto(id));

    return "city/city";
  }
}
