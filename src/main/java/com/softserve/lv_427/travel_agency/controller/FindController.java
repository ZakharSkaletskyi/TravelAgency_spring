package com.softserve.lv_427.travel_agency.controller;

import java.util.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.lv_427.travel_agency.dto.ClientPeriodDto;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import com.softserve.lv_427.travel_agency.service.CityService;
import com.softserve.lv_427.travel_agency.service.ClientService;
import com.softserve.lv_427.travel_agency.service.HotelService;
import com.softserve.lv_427.travel_agency.service.VisaService;

@Controller
public class FindController {
  private final ClientService clientService;
  private final VisaService visaService;
  private final CityService cityService;
  private final HotelService hotelService;

  @Autowired
  public FindController(ClientService clientService, VisaService visaService, CityService cityService, HotelService hotelService) {
    this.clientService = clientService;
    this.visaService = visaService;
    this.cityService = cityService;
    this.hotelService = hotelService;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView mainPage() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    return modelAndView;
  }

  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public String findPage(ModelMap model) {
    List<Client> clients = clientService.getAllClients();

    model.addAttribute("clients", clients);
    return "find/find";
  }

  @RequestMapping(value = "/find_country", method = RequestMethod.POST)
  public String findCountryPage(
      ModelMap model, @ModelAttribute("ClientPeriodDto") ClientPeriodDto clientPeriodDto)
      throws ClassNotFoundException {

    model.addAttribute(
        "ClientPeriodDto",
        clientService.getClientPeriodDto(
            clientPeriodDto.getId(), clientPeriodDto.getDateStart(), clientPeriodDto.getDateEnd()));

    List<Country> countries = clientService.getAvailableCountries(clientPeriodDto.getId());
    model.addAttribute("countries", countries);
    return "find/find_country";
  }

  @RequestMapping(value = "find_city", method = RequestMethod.POST)
  public String findCityPage(
      ModelMap model,
      @RequestParam("selectedCountry") int selectedCountryId,
      @ModelAttribute("ClientPeriodDto") ClientPeriodDto clientPeriodDto)
      throws ClassNotFoundException {
    ClientPeriodDto clientPeriodDTO = (ClientPeriodDto) model.get("ClientPeriodDto");
    List<City> cities =
        cityService.getCitiesWithAvailableHotels(
            selectedCountryId, clientPeriodDTO.getDateStart(), clientPeriodDTO.getDateEnd());
    cities.forEach(s -> System.out.print(s.getName() + " | ")); // print
    model.addAttribute("cities", cities);
    return "find/find_city";
  }

  @RequestMapping(value = "find_hotels", method = RequestMethod.POST)
  public String findHotelsPage(
      ModelMap model,
      @RequestParam("selectedCity") int selectedCityId,
      @ModelAttribute("ClientPeriodDto") ClientPeriodDto clientPeriodDto)
      throws ClassNotFoundException {
    List<Hotel> hotels =
        hotelService.getAvailableHotelsOnDatesInCity(
            selectedCityId, clientPeriodDto.getDateStart(), clientPeriodDto.getDateEnd());
    hotels.forEach(s -> System.out.print(s.getName() + " | ")); // print
    System.out.println();
    model.addAttribute("hotels", hotels);
    return "find/find_hotels";
  }
}
