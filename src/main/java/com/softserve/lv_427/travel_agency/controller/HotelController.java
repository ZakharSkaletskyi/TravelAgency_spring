package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.dto.hotel.HotelDto;
import com.softserve.lv_427.travel_agency.dto.hotel.HotelWithAvailabilityDto;
import com.softserve.lv_427.travel_agency.dto.hotel.HotelWithStatisticDto;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import com.softserve.lv_427.travel_agency.service.CityService;
import com.softserve.lv_427.travel_agency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {
  private final HotelService hotelService;
  private final CityService cityService;

  @Autowired
  public HotelController(HotelService hotelService, CityService cityService) {
    this.hotelService = hotelService;
    this.cityService = cityService;
  }

  @GetMapping
  public ModelAndView getHotel(@RequestParam String name) {
    ModelAndView modelAndView = new ModelAndView();
    HotelDto dto = hotelService.getHotelDtoById(name);

    modelAndView.setViewName("hotel/hotel");
    modelAndView.addObject("hotelDto", dto);

    return modelAndView;
  }

  @GetMapping("/availability")
  public ModelAndView getHotelAvailability(
      @RequestParam String hotelName, String startDateAvail, String endDateAvail) {
    ModelAndView modelAndView = new ModelAndView();
    HotelWithAvailabilityDto dto =
        hotelService.getHotelWithAvailabilityDtoById(hotelName, startDateAvail, endDateAvail);

    modelAndView.setViewName("hotel/hotel_with_availability");
    modelAndView.addObject("hotelDto", dto);

    return modelAndView;
  }

  @GetMapping("/stat")
  public ModelAndView getHotelStat(
      @RequestParam String hotelName, String startDateStat, String endDateStat) {
    ModelAndView modelAndView = new ModelAndView();
    HotelWithStatisticDto dto =
        hotelService.getHotelWithStatisticDtoById(hotelName, startDateStat, endDateStat);

    modelAndView.setViewName("hotel/hotel_with_stat");
    modelAndView.addObject("hotelDto", dto);

    return modelAndView;
  }

  @GetMapping(value = "/all")
  public ModelAndView getAllHotels() {
    List<Hotel> hotels = hotelService.getAll();

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("hotel/hotels");
    modelAndView.addObject("hotels", hotels);

    return modelAndView;
  }

  @PostMapping(value = "/all")
  public ModelAndView getAllHotelsInCity(@RequestParam Integer cityId) {
    List<Hotel> hotels = cityService.getHotels(cityId);

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("hotel/hotels");
    modelAndView.addObject("hotels", hotels);

    return modelAndView;
  }
}
