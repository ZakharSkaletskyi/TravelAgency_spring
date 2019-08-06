package com.softserve.lv_427.travel_agency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.lv_427.travel_agency.dto.ClientPeriodDto;
import com.softserve.lv_427.travel_agency.dto.FindHotelDto;
import com.softserve.lv_427.travel_agency.dto.FindHotelStatDto;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import com.softserve.lv_427.travel_agency.service.CityService;
import com.softserve.lv_427.travel_agency.service.ClientService;
import com.softserve.lv_427.travel_agency.service.HotelService;

@Controller
@SessionAttributes("findHotelDto")
public class FindController {
  @Autowired private ClientService clientService;
  @Autowired private CityService cityService;
  @Autowired private HotelService hotelService;

  @ModelAttribute("findHotelDto")
  public FindHotelDto findHotelDto() {
    return new FindHotelDto();
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
    hotels.forEach(s -> System.out.print(s.getName() + " | "));
    System.out.println();
    model.addAttribute("hotels", hotels);
    return "find/find_hotels";
  }

  @RequestMapping(value = "find_hotel", method = RequestMethod.POST)
  public String findHotelsPage(
      ModelMap model, @ModelAttribute("findHotelDto") FindHotelDto findHotelDto) {
    hotelService.fillFindHotelDtoWithHotelsAtributes(findHotelDto);
    model.addAttribute("findHotelDto", findHotelDto);
    return "find/find_hotel";
  }

  @RequestMapping(value = "find_hotel", params = "action1", method = RequestMethod.GET)
  public String getStatistic(
      ModelMap model,
      @RequestParam("start_date_hotel_stat") String startDateHotelStat,
      @RequestParam("end_date_hotel_stat") String endDateHotelStat,
      @ModelAttribute("findHotelStatDto") FindHotelStatDto findHotelStatDto) {

    System.out.println("Button was pressed!!!");
    System.out.println(
        "before findHotelStatDto="
            + model.containsAttribute("findHotelStatDto")
            + " id="
            + findHotelStatDto.getHotelId());
    hotelService.fillFindHotelStatDto(findHotelStatDto, startDateHotelStat, endDateHotelStat);
    model.addAttribute("findHotelStatDto", findHotelStatDto);
    System.out.println(
        "findHotelDto name="
            + findHotelStatDto.getHotelId()
            + " "
            + hotelService.getById(findHotelStatDto.getHotelId()).getName());
    return "find/find_hotel";
  }
}
