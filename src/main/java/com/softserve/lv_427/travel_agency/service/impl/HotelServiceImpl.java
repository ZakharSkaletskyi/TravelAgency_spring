package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.HotelDao;
import com.softserve.lv_427.travel_agency.dto.FindHotelDto;
import com.softserve.lv_427.travel_agency.dto.FindHotelStatDto;
import com.softserve.lv_427.travel_agency.dto.HotelDto;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import com.softserve.lv_427.travel_agency.entity.Room;
import com.softserve.lv_427.travel_agency.service.HotelService;
import com.softserve.lv_427.travel_agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Service for Hotel using HotelDao.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
@Service
public class HotelServiceImpl implements HotelService {
  private final HotelDao dao;
  private final RoomService roomService;

  @Autowired
  public HotelServiceImpl(HotelDao dao, RoomService roomService) {
    this.dao = dao;
    this.roomService = roomService;
  }

  /**
   * Add Hotel entity to DB.
   *
   * @param hotel - Hotel entity.
   */
  @Override
  public void add(Hotel hotel) {
    dao.add(hotel);
  }

  /**
   * Get hotel from DB by id.
   *
   * @param id - hotel id.
   * @return Hotel entity.
   */
  @Override
  public Hotel getById(int id) {
    return dao.getById(id);
  }

  /**
   * Delete hotel from DB.
   *
   * @param hotel - hotel entity.
   */
  @Override
  public void delete(Hotel hotel) {
    dao.delete(hotel);
  }

  /**
   * Edit hotel in DB.
   *
   * @param hotel - hotel entity.
   */
  @Override
  public void edit(Hotel hotel) {
    dao.edit(hotel);
  }

  /**
   * Get all hotels from DB.
   *
   * @return List of Hotels.
   */
  @Override
  public List<Hotel> getAll() {
    return dao.getAll();
  }

  /**
   * Get count of clients on period in hotel.
   *
   * @param hotelId - hotel id.
   * @param dateStart - start date.
   * @param dateEnd - end date
   * @return int - count of clients.
   */
  @Override
  public int getClientCountForPeriod(int hotelId, String dateStart, String dateEnd) {
    return dao.getClientCountForPeriod(hotelId, dateStart, dateEnd);
  }

  /**
   * Get all available hotels no period.
   *
   * @param dateStart - start date.
   * @param dateEnd - end date
   * @return List of hotels.
   */
  @Override
  public List<Hotel> getAvailableHotelsOnDates(String dateStart, String dateEnd) {
    return dao.getAvailableHotelsOnDates(dateStart, dateEnd);
  }

  /**
   * Get average book time in hotel on period.
   *
   * @param hotelId - hotel id.
   * @param dateStart - start date.
   * @param dateEnd - end date
   * @return average book time in days.
   */
  @Override
  public int getAverageBookTime(int hotel_id, String dateStart, String dateEnd) {
    return dao.getAverageBookTime(hotel_id, dateStart, dateEnd);
  }

  /**
   * Get rooms in hotel.
   *
   * @param hotelId - hotel id.
   * @return List of rooms.
   */
  @Override
  public List<Room> getRoomsByHotel(int hotelId) {
    return dao.getRoomsByHotel(hotelId);
  }

  /**
   * Get HotelDto for main hotel page.
   *
   * @param hotelId - hotel id.
   * @return HotelDto for controller.
   */
  @Override
  public HotelDto getHotelDtoById(int hotelId) {
    Hotel hotel = getById(hotelId);
    Calendar nextYearC = Calendar.getInstance();
    Calendar twoYearsAgoC = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    nextYearC.add(Calendar.YEAR, 1);
    Date nextYear = nextYearC.getTime();

    twoYearsAgoC.add(Calendar.YEAR, -2);
    Date twoYearsAgo = twoYearsAgoC.getTime();

    return new HotelDto(
        hotel.getId(),
        hotel.getName(),
        hotel.getCity().getCountry(),
        hotel.getCity(),
        dateFormat.format(new Date()),
        dateFormat.format(twoYearsAgo),
        dateFormat.format(nextYear));
  }

  /**
   * Get HotelDto for hotel page which shows is hotel rooms are available.
   *
   * @param hotelId - hotel id.
   * @return HotelDto for controller.
   */
  @Override
  public HotelDto getHotelDtoWithAvailabilityById(int hotelId, String startDate, String endDate) {
    Hotel hotel = getById(hotelId);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Calendar twoYearsAgoC = Calendar.getInstance();
    twoYearsAgoC.add(Calendar.YEAR, -2);
    Date twoYearsAgo = twoYearsAgoC.getTime();

    return new HotelDto(
        hotel.getId(),
        hotel.getName(),
        hotel.getCity().getCountry(),
        hotel.getCity(),
        dateFormat.format(new Date()),
        dateFormat.format(twoYearsAgo),
        startDate,
        endDate,
        roomService.getAvailableRoomsOnDateInHotel(startDate, endDate, hotelId));
  }

  /**
   * Get HotelDto for hotel page which shows hotel statistic for the period.
   *
   * @param hotelId - hotel id.
   * @return HotelDto for controller.
   */
  @Override
  public HotelDto getHotelDtoWithStatisticById(int hotelId, String startDate, String endDate) {
    Hotel hotel = getById(hotelId);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar nextYearC = Calendar.getInstance();
    List<Room> rooms = getRoomsByHotel(hotelId);
    List<int[]> roomLoading = new ArrayList<>();

    nextYearC.add(Calendar.YEAR, 1);
    Date nextYear = nextYearC.getTime();

    for (Room room : rooms) {
      roomLoading.add(roomService.loadingRoomsPeriod(startDate, endDate, room.getId()));
    }

    return new HotelDto(
        hotel.getId(),
        hotel.getName(),
        hotel.getCity().getCountry(),
        hotel.getCity(),
        dateFormat.format(new Date()),
        dateFormat.format(nextYear),
        startDate,
        endDate,
        getClientCountForPeriod(hotelId, startDate, endDate),
        getAverageBookTime(hotelId, startDate, endDate),
        roomLoading);
  }

  @Override
  @Transactional
  public List<Hotel> getAvailableHotelsOnDatesInCity(int cityId, String startDate, String endDate)
      throws ClassNotFoundException {
    return dao.getAvailableHotelsOnDatesInCity(cityId, startDate, endDate);
  }

  @Override
  @Transactional
  public void fillFindHotelDtoWithHotelsAtributes(FindHotelDto findHotelDto) {
    Hotel hotel = dao.getById(findHotelDto.getHotelId());
    findHotelDto.setName(hotel.getName());
    findHotelDto.setRoomsCount(roomService.getRoomCount(findHotelDto.getHotelId()));
    findHotelDto.setRoomsCount(roomService.getRoomCount(findHotelDto.getHotelId()));

    findHotelDto.setAvaibleRoomsNumber(
        roomService.getAvaibleRoomsNumber(
            findHotelDto.getHotelId(), findHotelDto.getDateStart(), findHotelDto.getDateEnd()));
  }

  @Override
  public void fillFindHotelStatDto(
      FindHotelStatDto findHotelStatDto, String dateStart, String dateEnd) {
    findHotelStatDto.setStartDateHotelStat(dateStart);
    findHotelStatDto.setEndDateHotelStat(dateEnd);
    findHotelStatDto.setClientsCountsForPeriod(
        getClientCountForPeriod(findHotelStatDto.getHotelId(), dateStart, dateEnd));
    findHotelStatDto.setAverageBookTimeForPeriod(
        getAverageBookTime(findHotelStatDto.getHotelId(), dateStart, dateEnd));
    findHotelStatDto.setRoomsLoadingForPeriod(
        getRoomsLoadingForPeriod(findHotelStatDto.getHotelId(), dateStart, dateEnd));
  }

  @Override
  public List<Integer> getRoomsLoadingForPeriod(int hotelId, String dateStart, String dateEnd) {
    List<Integer> roomsLoading = new ArrayList<Integer>();
    for (int roomId : roomService.getRoomsId(hotelId)) {
      roomsLoading.add(roomService.loadingRoomsPeriod(dateStart, dateEnd, roomId)[0]);
    }
    return roomsLoading;
  }
}
