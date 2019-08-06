package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dao.RoomDao;
import com.softserve.lv_427.travel_agency.dao.impl.RoomDaoImpl;
import com.softserve.lv_427.travel_agency.entity.Room;
import com.softserve.lv_427.travel_agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RoomServiceImpl implements RoomService {
  private final RoomDao dao;

  @Autowired
  public RoomServiceImpl(RoomDaoImpl dao) {
    this.dao = dao;
  }

  @Override
  @Transactional
  public void add(Room room) {
    dao.add(room);
  }

  @Override
  @Transactional
  public Room getById(int id) {
    return dao.getById(id);
  }

  @Override
  @Transactional
  public void delete(Room room) {
    dao.delete(room);
  }

  @Override
  @Transactional
  public void edit(Room room) {
    dao.edit(room);
  }

  @Override
  @Transactional
  public List<Room> getAvailableRoomsOnDateInHotel(String startDate, String endDate, int hotelId) {
    return dao.getAvailableRoomsOnDateInHotel(startDate, endDate, hotelId);
  }

  @Override
  @Transactional
  public int getLoadingRoomsPeriod(String startDate, String endDate, int roomId) {
    return dao.getLoadingRoomsPeriod(startDate, endDate, roomId);
  }

  @Override
  @Transactional
  public int[] loadingRoomsPeriod(String startDate, String endDate, int roomId) {
    int[] loading = new int[2];
    loading[0] = dao.getLoadingRoomsPeriod(startDate, endDate, roomId);
    loading[1] = getLoadingPeriod(startDate, endDate);
    return loading;
  }

  @Override
  @Transactional
  public int getLoadingPeriod(String startDate, String endDate) {
    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
    Long periodL = null;

    try {
      Date date1 = myFormat.parse(startDate);
      Date date2 = myFormat.parse(endDate);
      Long diff = date2.getTime() - date1.getTime();
      periodL = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return periodL.intValue();
  }

  @Override
  @Transactional
  public int getRoomCount(int hotelId) {
    return dao.getRoomCount(hotelId);
  }
  @Override
  @Transactional
  public List<Integer> getAvaibleRoomsNumber(int hotelId, String dateStart, String dateEnd) {
    return dao.getAvaibleRoomsNumber(hotelId, dateStart, dateEnd);
  }

  @Override
  @Transactional
  public List<Integer> getRoomsId(int hotelId) {
    return dao.getRoomsId(hotelId);
  }

}
