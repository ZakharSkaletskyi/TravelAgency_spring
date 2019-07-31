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

import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.service.ClientService;

@Controller
public class FindCountryController {
  @Autowired private ClientService clientService;

  @RequestMapping(value = "/find_country", method = RequestMethod.GET)
  public ModelAndView editPage(
      @RequestParam("selectedClient") int selectedClientId,
      @RequestParam("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
      @RequestParam("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd)
      throws ClassNotFoundException {

    System.out.println("from" + dateStart);
    System.out.println("to" + dateEnd.toString());
    System.out.println("selectedClient=" + selectedClientId);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("find/find_country");
    modelAndView.addObject("dateStart", dateStart);
    modelAndView.addObject("dateEnd", dateEnd);
    
    List<Country> countries = clientService.getAvailableCountries(selectedClientId);
    countries.forEach(s -> System.out.print(s.getName() + " | ")); // print
    System.out.println();
    modelAndView.addObject("countries", countries);
    return modelAndView;
  }
}
