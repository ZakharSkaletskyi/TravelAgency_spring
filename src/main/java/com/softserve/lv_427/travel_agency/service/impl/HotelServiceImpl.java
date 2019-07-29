package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.HotelDao;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import com.softserve.lv_427.travel_agency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
  private final HotelDao dao;

  @Autowired
  public HotelServiceImpl(HotelDao dao) {
    this.dao = dao;
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
}
