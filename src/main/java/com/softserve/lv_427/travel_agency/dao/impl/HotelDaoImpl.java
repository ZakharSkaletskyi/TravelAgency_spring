package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.HotelDao;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelDaoImpl implements HotelDao {
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void add(Hotel hotel) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(hotel);
  }

  @Override
  public Hotel getById(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Hotel.class, id);
  }

  @Override
  public void delete(Hotel hotel) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(hotel);
  }

  @Override
  public void edit(Hotel hotel) {
    Session session = sessionFactory.getCurrentSession();
    session.update(hotel);
  }

  @Override
  public List<Hotel> getAll() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("FROM Hotel", Hotel.class).list();
  }

  @Override
  public int getId(String name) {
    Session session = sessionFactory.getCurrentSession();
    return session
        .createQuery("Select id from Hotel where name = ?1", Integer.class)
        .setParameter(1, name)
        .uniqueResult();
  }

  @Override
  public int getClientCountForPeriod(int hotel_id, String dateStart, String dateEnd) {
    Session session = sessionFactory.getCurrentSession();

    List<Integer> roomIds =
        session
            .createQuery("SELECT id FROM Room where hotel.id = ?1", Integer.class)
            .setParameter(1, hotel_id)
            .list();

    return session
        .createQuery(
            "SELECT COUNT(client.id) FROM RoomBookArchive WHERE (orderStart >= ?1 AND orderEnd <= ?2 AND room.id IN (:roomIds))",
            Long.class)
        .setParameter(1, dateStart)
        .setParameter(2, dateEnd)
        .setParameterList("roomIds", roomIds)
        .uniqueResult()
        .intValue();
  }

  @Override
  public List<Hotel> getAvailableHotelsOnDates(String startDate, String endDate) {
    Session session = sessionFactory.getCurrentSession();

    List<Integer> roomIds =
        session
            .createQuery(
                "SELECT room.id FROM RoomBook"
                    + " WHERE ((orderStart > ?1 AND orderStart < ?2)"
                    + " OR (orderStart < ?3 AND orderEnd > ?4)"
                    + " OR (orderEnd > ?5 AND orderEnd < ?6))",
                Integer.class)
            .setParameter(1, startDate)
            .setParameter(2, endDate)
            .setParameter(3, startDate)
            .setParameter(4, endDate)
            .setParameter(5, startDate)
            .setParameter(6, endDate)
            .list();

    List<Integer> hotelIds =
        session
            .createQuery(
                "SELECT distinct hotel.id FROM Room WHERE id NOT IN (:roomIds)", Integer.class)
            .setParameterList("roomIds", roomIds)
            .list();

    return session
        .createQuery("from Hotel where id IN (:hotelIds)", Hotel.class)
        .setParameterList("hotelIds", hotelIds)
        .list();
  }

  @Override // переробити - спочату вибрати всі зайняті, а потім серед всіх готелів в місті вибрати
  // ті які не в списку зайнятих
  public List<Hotel> getAvailableHotelsOnDatesInCity(int cityId, String startDate, String endDate)
      throws ClassNotFoundException {
	  List<Hotel> hotels;
    Session session = sessionFactory.getCurrentSession();
    List<Integer> bookedHotelsId =
        session
            .createQuery(
                "SELECT h.id FROM City c JOIN c.hotels h JOIN h.rooms r LEFT JOIN r.roomBooks rb WHERE "
                + "(c.id= ?1 "
//                + ")",  //test
                + "AND ((rb.orderStart > ?2 AND rb.orderStart < ?3)"
                		+ " OR (rb.orderStart < ?4 AND rb.orderEnd > ?5)"
                		+ " OR (rb.orderEnd > ?6 AND rb.orderEnd < ?7)))",
                Integer.class) // change
            .setParameter(1, cityId)
            .setParameter(2, startDate)
            .setParameter(3, endDate)
            .setParameter(4, startDate)
            .setParameter(5, endDate)
            .setParameter(6, startDate)
            .setParameter(7, endDate)
            .list();
    {/////////////////////////////////////////////test
    	System.out.println("hotels bookedId HDao" ); 
    	bookedHotelsId.forEach(s->System.out.print(s+" | "));
    }
    System.out.println("bookedHotelsId.size="+bookedHotelsId.size());
    if(bookedHotelsId.size()==0)
    {System.out.println("111111111111");
	 hotels =
	        session
	            .createQuery(
	                "SELECT h FROM City c JOIN c.hotels h WHERE c.id= ?1 ",
	                Hotel.class) // change
	            .setParameter(1, cityId)
	            .list();
    	
    }
    else
    {System.out.println("2222222222222");
     hotels =
        session
            .createQuery(
                "SELECT h FROM City c JOIN c.hotels h WHERE c.id= ?1 AND h.id NOT IN (:bookedHotelsId) ",
                Hotel.class) // change
            .setParameter(1, cityId)
            .setParameterList("bookedHotelsId", bookedHotelsId)
            .list();
  }
    if (hotels == null){
      throw new ClassNotFoundException("In DB no avaible countries for clientId= " + cityId);
    }
    {/////////////////////////////////////////////test
    	System.out.println("hotels HDao" ); 
    hotels.forEach(s->System.out.print(s+" | "));
    }
    return hotels;
    
  }

  @Override
  public int getAverageBookTime(int hotel_id, String dateStart, String dateEnd) {
    Session session = sessionFactory.getCurrentSession();

    List<Object[]> bookDaysArchive =
        new ArrayList<Object[]>(
            session
                .createQuery(
                    "SELECT orderStart, orderEnd FROM RoomBookArchive WHERE "
                        + "(orderStart >= ?1  AND orderEnd <= ?2 AND room.id IN "
                        + "(SELECT id FROM Room where hotel.id = ?3))",
                    Object[].class)
                .setParameter(1, dateStart)
                .setParameter(2, dateEnd)
                .setParameter(3, hotel_id)
                .list());

    List<Integer> dateDifference1 = new ArrayList<>();
    for (Object[] date : bookDaysArchive) {
      dateDifference1.add(getDaysFromPeriod((String) date[0], (String) date[1]));
    }

    List<Object[]> bookDaysNow =
        new ArrayList<Object[]>(
            session
                .createQuery(
                    "SELECT orderStart, orderEnd FROM RoomBook WHERE "
                        + "(orderStart >= ?1  AND orderEnd <= ?2 AND room.id IN "
                        + "(SELECT id FROM Room where hotel.id = ?3))",
                    Object[].class)
                .setParameter(1, dateStart)
                .setParameter(2, dateEnd)
                .setParameter(3, hotel_id)
                .list());

    List<Integer> dateDifference2 = new ArrayList<>();
    for (Object[] date : bookDaysNow) {
      dateDifference2.add(getDaysFromPeriod((String) date[0], (String) date[1]));
    }

    List<Integer> bookDays = new ArrayList<>();
    bookDays.addAll(dateDifference1);
    bookDays.addAll(dateDifference2);

    return bookDays.size() > 0
        ? bookDays.stream().mapToInt(Integer::intValue).sum() / bookDays.size()
        : 0;
  }

  private int getDaysFromPeriod(String dateStart, String dateEnd) {
    int[] firstDay = get3Int(dateStart);
    int[] lastDay = get3Int(dateEnd);
    LocalDate start = LocalDate.of(firstDay[0], firstDay[1], firstDay[2]);
    LocalDate end = LocalDate.of(lastDay[0], lastDay[1], lastDay[2]);
    return (int) ChronoUnit.DAYS.between(start, end);
  }

  private int[] get3Int(String s) {
    String[] s1 = s.split("-");
    int[] n = new int[3];
    for (int i = 0; i < 3; i++) {
      n[i] = Integer.parseInt(s1[i]);
    }
    return n;
  }
}
