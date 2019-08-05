package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.external.Validator;
import com.softserve.lv_427.travel_agency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for Hotel logic.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
@Controller
public class HotelController {
  private final HotelService hotelService;
  private Validator validator = new Validator();

  @Autowired
  public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
  }

  /** Method that returns all hotels. */
  @GetMapping(value = "/hotels")
  public String getAllHotels(ModelMap model) {
    model.addAttribute("hotels", hotelService.getAll());

    return "hotel/hotels";
  }

  /** Method that returns Hotel by his id. */
  @GetMapping(value = "/hotel")
  public String getHotel(@RequestParam int id, ModelMap model) {
    model.addAttribute("hotelDto", hotelService.getHotelDtoById(id));

    return "hotel/hotel";
  }

  /** Method that returns page with information about available rooms. */
  @PostMapping("/hotel/availability")
  public String getHotelWithAvailability(
      @RequestParam int id, String startDateAvail, String endDateAvail, ModelMap model) {
    validator.validateDateForAvailability(startDateAvail, endDateAvail);
    model.addAttribute(
        "hotelDto", hotelService.getHotelDtoWithAvailabilityById(id, startDateAvail, endDateAvail));

    return "hotel/hotel";
  }

  /** Method that returns page with hotel statistic for the period of time. */
  @PostMapping("/hotel/statistic")
  public String getHotelWithStatistic(
      @RequestParam int id, String startDateStat, String endDateStat, ModelMap model) {
    validator.validateDateForStatistic(startDateStat, endDateStat);
    model.addAttribute(
        "hotelDto", hotelService.getHotelDtoWithStatisticById(id, startDateStat, endDateStat));

    return "hotel/hotel";
  }
}
