package com.softserve.lv_427.travel_agency.service;

import com.softserve.lv_427.travel_agency.dto.hotel.HotelDto;
import com.softserve.lv_427.travel_agency.dto.hotel.HotelWithAvailabilityDto;
import com.softserve.lv_427.travel_agency.dto.hotel.HotelWithStatisticDto;
import com.softserve.lv_427.travel_agency.entity.Hotel;

import java.util.List;

public interface HotelService {
  void add(Hotel hotel);

  Hotel getById(int id);

  void delete(Hotel hotel);

  void edit(Hotel hotel);

  int getId(String name);

  List<Hotel> getAll();

  int getClientCountForPeriod(int hotel_id, String dateStart, String dateEnd);

  List<Hotel> getAvailableHotelsOnDates(String startDate, String endDate);

  int getAverageBookTime(int hotel_id, String dateStart, String dateEnd);

  HotelDto getHotelDtoById(String hotelName);

  HotelWithAvailabilityDto getHotelWithAvailabilityDtoById(
          String hotelName, String startDate, String endDate);

  HotelWithStatisticDto getHotelWithStatisticDtoById(String hotelName, String startDate, String endDate);
}
