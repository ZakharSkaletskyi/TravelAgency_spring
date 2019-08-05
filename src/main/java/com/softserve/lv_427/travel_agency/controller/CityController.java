package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/city")
public class CityController {
  private final CityService cityService;

  @Autowired
  public CityController(CityService cityService) {
    this.cityService = cityService;
  }

  @GetMapping
  public String getAllCities(ModelMap model) {
    model.addAttribute("cities", cityService.findAll());

    return "city/cities";
  }

  @PostMapping
  public String getCity(@RequestParam int cityId, ModelMap model) {
    model.addAttribute("city", cityService.getCityDto(cityId));

    return "city/city";
  }
}