package com.softserve.lv_427.travel_agency.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.service.CityService;

@Controller
public class FindCityController {
  @Autowired private CityService cityService;

  @RequestMapping(value = "/find_city", method = RequestMethod.GET)
  public ModelAndView editPage(
      @RequestParam("selectedCountry") int selectedCountryId,
      @RequestParam("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
      @RequestParam("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd)
      throws ClassNotFoundException {
    System.out.println("from" + dateStart);
    System.out.println("to" + dateEnd.toString());
    System.out.println("selectedCountry=" + selectedCountryId);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("find/find_country");

    List<City> cities =
        cityService.getCitiesWithAvailableHotels(
            selectedCountryId, dateStart.toString(), dateEnd.toString());
    cities.forEach(s -> System.out.print(s.getName() + " | ")); // print
    System.out.println();
    modelAndView.addObject("cities", cities);
    return modelAndView;
  }
}
