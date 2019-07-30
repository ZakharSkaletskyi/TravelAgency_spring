package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.HotelDao;
import com.softserve.lv_427.travel_agency.dto.hotel.HotelDto;
import com.softserve.lv_427.travel_agency.dto.hotel.HotelWithAvailabilityDto;
import com.softserve.lv_427.travel_agency.dto.hotel.HotelWithStatisticDto;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import com.softserve.lv_427.travel_agency.entity.Room;
import com.softserve.lv_427.travel_agency.service.HotelService;
import com.softserve.lv_427.travel_agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
  private final HotelDao dao;
  private final RoomService roomService;

  @Autowired
  public HotelServiceImpl(HotelDao dao, RoomService roomService) {
    this.dao = dao;
    this.roomService = roomService;
  }

  @Override
  @Transactional
  public void add(Hotel hotel) {
    dao.add(hotel);
  }

  @Override
  @Transactional
  public Hotel getById(int id) {
    return dao.getById(id);
  }

  @Override
  @Transactional
  public void delete(Hotel hotel) {
    dao.delete(hotel);
  }

  @Override
  @Transactional
  public void edit(Hotel hotel) {
    dao.edit(hotel);
  }

  @Override
  @Transactional
  public int getId(String name) {
    return dao.getId(name);
  }

  @Override
  @Transactional
  public List<Hotel> getAll() {
    return dao.getAll();
  }

  @Override
  @Transactional
  public int getClientCountForPeriod(int hotelId, String dateStart, String dateEnd) {
    return dao.getClientCountForPeriod(hotelId, dateStart, dateEnd);
  }

  @Override
  @Transactional
  public List<Hotel> getAvailableHotelsOnDates(String startDate, String endDate) {
    return dao.getAvailableHotelsOnDates(startDate, endDate);
  }

  @Override
  @Transactional
  public int getAverageBookTime(int hotel_id, String dateStart, String dateEnd) {
    return dao.getAverageBookTime(hotel_id, dateStart, dateEnd);
  }

  @Transactional
  @Override
  public HotelDto getHotelDtoById(String hotelName) {
    HotelDto dto = new HotelDto();
    int hotelId = getId(hotelName);
    Hotel hotel = getById(hotelId);
    String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    dto.setHotelName(hotel.getName());
    dto.setCurrentDate(currentDate);

    return dto;
  }

  @Transactional
  @Override
  public HotelWithAvailabilityDto getHotelWithAvailabilityDtoById(
      String hotelName, String startDate, String endDate) {
    HotelWithAvailabilityDto dto = new HotelWithAvailabilityDto();
    int hotelId = getId(hotelName);
    Hotel hotel = getById(hotelId);
    String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//    List<Room> rooms = roomService.getAvailableRoomsOnDateInHotel(startDate, endDate, hotelId);

    dto.setHotelName(hotel.getName());
    dto.setCurrentDate(currentDate);
    dto.setStartDate(startDate);
    dto.setEndDate(endDate);
//    dto.setAvailableRooms(rooms);

    return dto;
  }

  @Transactional
  @Override
  public HotelWithStatisticDto getHotelWithStatisticDtoById(
      String hotelName, String startDate, String endDate) {
    HotelWithStatisticDto dto = new HotelWithStatisticDto();
    int hotelId = getId(hotelName);
    Hotel hotel = getById(hotelId);

    String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    int countOfClient = getClientCountForPeriod(hotelId, startDate, endDate);
    int averageBookTime = getAverageBookTime(hotelId, startDate, endDate);
//    List<Integer[]> roomLoading = new ArrayList<>();

//    for (int i = 0; i < roomService.getRoomCount(hotelId); i++) {
      //      roomLoading.add(roomService.getLoadingRoomsPeriod(startDate, endDate, i));
//    }

    dto.setHotelName(hotel.getName());
    dto.setCurrentDate(currentDate);
    dto.setStartDate(startDate);
    dto.setEndDate(endDate);
    dto.setCountOfClient(countOfClient);
    dto.setAverageBookTime(averageBookTime);
//    dto.setRoomLoading(roomLoading);
    return dto;
  }
}
