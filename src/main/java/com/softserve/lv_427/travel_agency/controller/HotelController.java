package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hotel")
public class HotelController {
  private final HotelService hotelService;

  @Autowired
  public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
  }

  @GetMapping
  public String getAllHotels(ModelMap model) {
    model.addAttribute("hotels", hotelService.getAll());

    return "hotel/hotels";
  }

  @PostMapping
  public String getHotel(@RequestParam int hotelId, ModelMap model) {
    model.addAttribute("hotelDto", hotelService.getHotelDtoById(hotelId));

    return "hotel/hotel";
  }

  @PostMapping("/availability")
  public String getHotelWithAvailability(
      @RequestParam int hotelId, String startDateAvail, String endDateAvail, ModelMap model) {
    model.addAttribute(
        "hotelDto",
        hotelService.getHotelDtoWithAvailabilityById(hotelId, startDateAvail, endDateAvail));

    return "hotel/hotel";
  }

  @PostMapping("/statistic")
  public String getHotelWithStatistic(
      @RequestParam int hotelId, String startDateStat, String endDateStat, ModelMap model) {
    model.addAttribute(
        "hotelDto", hotelService.getHotelDtoWithStatisticById(hotelId, startDateStat, endDateStat));

    return "hotel/hotel";
  }
}
