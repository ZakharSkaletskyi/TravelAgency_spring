package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.RoomDao;
import com.softserve.lv_427.travel_agency.entity.Room;
import com.softserve.lv_427.travel_agency.service.external.DaysService;
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
  private final DaysService daysService;

  @Autowired
  public RoomDaoImpl(DaysService daysService) {
    this.daysService = daysService;
  }

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
            "SELECT r from Hotel h join h.rooms r left join r.roomBooks rb where "
                + " (rb.orderStart > ?1 OR rb.orderEnd < ?2"
                + "OR rb.orderStart is null) AND h.id = ?3",
            Room.class)
        .setParameter(1, endDate)
        .setParameter(2, startDate)
        .setParameter(3, hotelId)
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
                        + "orderStart >= ?1  AND orderEnd <= ?2 AND room.id = ?3",
                    Object[].class)
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .setParameter(3, roomId)
                .list());
    List<Integer> dateDifference = new ArrayList<>();
    for (Object[] date : roomsLoading) {
      dateDifference.add(daysService.getDaysFromPeriod((String) date[0], (String) date[1]));
    }
    return dateDifference.size() > 0
        ? dateDifference.stream().mapToInt(Integer::intValue).sum()
        : 0;
  }

  @Override
  public int getRoomCount(int hotelId) {
    Session session = sessionFactory.getCurrentSession();
    return session
        .createQuery("select count (id) from Room where hotel.id = ?1", Long.class)
        .setParameter(1, hotelId)
        .uniqueResult()
        .intValue();
  }
  public List<Integer> getAvaibleRoomsNumber(int id){
 	 
  }
}
