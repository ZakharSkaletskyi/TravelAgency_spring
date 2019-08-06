package com.softserve.lv_427.travel_agency.service;

import com.softserve.lv_427.travel_agency.dto.FindHotelDto;
import com.softserve.lv_427.travel_agency.dto.FindHotelStatDto;
import com.softserve.lv_427.travel_agency.dto.HotelDto;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import com.softserve.lv_427.travel_agency.entity.Room;

import java.util.List;

public interface HotelService {
  void add(Hotel hotel);

  Hotel getById(int id);

  void delete(Hotel hotel);

  void edit(Hotel hotel);

  List<Hotel> getAll();

  int getClientCountForPeriod(int hotel_id, String dateStart, String dateEnd);

  List<Hotel> getAvailableHotelsOnDates(String startDate, String endDate);

  int getAverageBookTime(int hotel_id, String dateStart, String dateEnd);

  List<Room> getRoomsByHotel(int hotelId);

  HotelDto getHotelDtoById(int hotelId);

  HotelDto getHotelDtoWithAvailabilityById(int hotelId, String startDate, String endDate);

  HotelDto getHotelDtoWithStatisticById(int hotelId, String startDate, String endDate);

  List<Hotel> getAvailableHotelsOnDatesInCity(int cityId, String startDate, String endDate)
      throws ClassNotFoundException;

  void fillFindHotelDtoWithHotelsAtributes(FindHotelDto findHotelDto);

  List<Integer> getRoomsLoadingForPeriod(int hotelId, String dateStart, String dateEnd);

  void fillFindHotelStatDto(FindHotelStatDto findHotelStatDto, String dateStart, String dateEnd);
}
