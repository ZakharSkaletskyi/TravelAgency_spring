package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.RoomDao;
import com.softserve.lv_427.travel_agency.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class RoomDaoImpl implements RoomDao {
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void add(Room room) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(room);
  }

  @Override
  public Room getById(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Room.class, id);
  }

  @Override
  public void delete(Room room) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(room);
  }

  @Override
  public void edit(Room room) {
    Session session = sessionFactory.getCurrentSession();
    session.update(room);
  }

  @Override
  public List<Room> getAvailableRoomsOnDateInHotel(String startDate, String endDate, int hotelId) {
    Session session = sessionFactory.getCurrentSession();

    return session
        .createQuery(
            "SELECT r from Hotel h join h.rooms r join r.roomBooks rb where "
                + " ((rb.orderStart < ?1 AND rb.orderStart > ?2)"
                + " OR (rb.orderStart > ?3 AND rb.orderEnd < ?4)"
                + " OR (rb.orderEnd < ?5 AND rb.orderEnd < ?6))"
                + " AND h.id = ?7",
            Room.class)
        .setParameter(1, startDate)
        .setParameter(2, endDate)
        .setParameter(3, startDate)
        .setParameter(4, endDate)
        .setParameter(5, startDate)
        .setParameter(6, endDate)
        .setParameter(7, hotelId)
        .list();
  }

  @Override
  public int getLoadingRoomsPeriod(String startDate, String endDate, int roomId) {
    Session session = sessionFactory.getCurrentSession();
    List<Object[]> roomsLoading =
        new ArrayList<Object[]>(
            session
                .createQuery(
                    "SELECT orderStart, orderEnd FROM RoomBookArchive WHERE "
                        + "(orderStart >= ?1  AND orderEnd <= ?2 AND room.id IN "
                        + "(SELECT id FROM Room where room.id = ?3))",
                    Object[].class)
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .setParameter(3, roomId)
                .list());
    List<Integer> dateDifference = new ArrayList<>();
    for (Object[] date : roomsLoading) {
      dateDifference.add(getDaysFromPeriod((String) date[0], (String) date[1]));
    }
    return dateDifference.size() > 0
        ? dateDifference.stream().mapToInt(Integer::intValue).sum()
        : 0;
  }

  @Override
  public int getRoomCount(int hotelId) {
    Session session = sessionFactory.getCurrentSession();
    return session
        .createQuery("select count (id) from Room where hotel.id = ?1", Integer.class)
        .setParameter(1, hotelId)
        .uniqueResult();
  }

  public int getDaysFromPeriod(String dateStart, String dateEnd) {
    int[] firstDay = get3Int(dateStart);
    int[] lastDay = get3Int(dateEnd);
    LocalDate start = LocalDate.of(firstDay[0], firstDay[1], firstDay[2]);
    LocalDate end = LocalDate.of(lastDay[0], lastDay[1], lastDay[2]);
    return (int) ChronoUnit.DAYS.between(start, end);
  }

  public int[] get3Int(String s) {
    String[] s1 = s.split("-");
    int[] n = new int[3];
    for (int i = 0; i < 3; i++) {
      n[i] = Integer.parseInt(s1[i]);
    }
    return n;
  }
}
