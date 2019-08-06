package com.softserve.lv_427.travel_agency.service.external;

import com.softserve.lv_427.travel_agency.dao.impl.*;
import com.softserve.lv_427.travel_agency.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;

@Service
public class AutoPopulateDB {
  private final CityDaoImpl cityDao;
  private final ClientDaoImpl clientDao;
  private final CountryDaoImpl countryDao;
  private final HotelDaoImpl hotelDao;
  private final RoomBookArchiveDaoImpl roomBookArchiveDao;
  private final RoomBookDaoImpl roomBookDao;
  private final RoomDaoImpl roomDao;
  private final VisaDaoImpl visaDao;

  @Autowired
  public AutoPopulateDB(
      CityDaoImpl cityDao,
      ClientDaoImpl clientDao,
      CountryDaoImpl countryDao,
      HotelDaoImpl hotelDao,
      RoomBookArchiveDaoImpl roomBookArchiveDao,
      RoomBookDaoImpl roomBookDao,
      RoomDaoImpl roomDao,
      VisaDaoImpl visaDao) {
    this.cityDao = cityDao;
    this.clientDao = clientDao;
    this.countryDao = countryDao;
    this.hotelDao = hotelDao;
    this.roomBookArchiveDao = roomBookArchiveDao;
    this.roomBookDao = roomBookDao;
    this.roomDao = roomDao;
    this.visaDao = visaDao;
  }

  @Transactional
  public void populate() throws ParseException {
    Visa jq = new Visa();
    jq.setName("J Q");
    Visa britishTourist = new Visa();
    britishTourist.setName("British tourist");

    Country usa = new Country();
    usa.setName("USA");
    usa.setVisa(jq);
    Country england = new Country();
    england.setName("England");
    england.setVisa(britishTourist);

    Client nazar = new Client();
    nazar.setFirstName("Nazar");
    nazar.setLastName("Vladyka");
    nazar.setPhoneNumber("0975899856");
    nazar.setVisas(Arrays.asList(jq, britishTourist));
    nazar.setCountries(Collections.singletonList(usa));

    Client zakhar = new Client();
    zakhar.setFirstName("Zakhar");
    zakhar.setLastName("Skaletskyy");
    zakhar.setPhoneNumber("0989885631");
    zakhar.setVisas(Collections.singletonList(jq));
    zakhar.setCountries(Arrays.asList(usa, england));

    Client alexandr = new Client();
    alexandr.setFirstName("Alexandr");
    alexandr.setLastName("Agarkov");
    alexandr.setPhoneNumber("0962538746");
    alexandr.setVisas(Collections.singletonList(britishTourist));
    zakhar.setCountries(Arrays.asList(usa, england));

    //    jq.setCountries(Collections.singletonList(usa));
    //    britishTourist.setCountries(Collections.singletonList(england));

    City tennessee = new City();
    tennessee.setName("Tennessee");
    tennessee.setCountry(usa);
    City lasVegas = new City();
    lasVegas.setName("Las Vegas");
    lasVegas.setCountry(usa);
    City london = new City();
    london.setName("London");
    london.setCountry(england);
    City cambridge = new City();
    cambridge.setName("Cambridge");
    cambridge.setCountry(england);

    //    usa.setCities(Arrays.asList(tennessee, lasVegas));
    //    england.setCities(Arrays.asList(london, cambridge));

    Hotel sheraton = new Hotel();
    sheraton.setName("Sheraton Music City");
    sheraton.setCity(tennessee);
    Hotel wildBear = new Hotel();
    wildBear.setName("Wild Bear Inn");
    wildBear.setCity(tennessee);
    Hotel galaxy = new Hotel();
    galaxy.setName("Hotel Galaxy");
    galaxy.setCity(lasVegas);
    Hotel theD = new Hotel();
    theD.setName("The D");
    theD.setCity(lasVegas);
    Hotel restup = new Hotel();
    restup.setName("Restup London");
    restup.setCity(london);
    Hotel lewisham = new Hotel();
    lewisham.setName("Via Lewisham Hostel");
    lewisham.setCity(london);
    Hotel felix = new Hotel();
    felix.setName("Hotel Felix");
    felix.setCity(cambridge);
    Hotel gonville = new Hotel();
    gonville.setName("Gonville Hotel");
    gonville.setCity(cambridge);

    //    tennessee.setHotels(Arrays.asList(sheraton, wildBear));
    //    lasVegas.setHotels(Arrays.asList(galaxy, theD));
    //    london.setHotels(Arrays.asList(restup, lewisham));
    //    cambridge.setHotels(Arrays.asList(felix, gonville));

    Room number1_1 = new Room();
    number1_1.setNumber(1);
    number1_1.setHotel(sheraton);
    Room number2_1 = new Room();
    number2_1.setNumber(2);
    number2_1.setHotel(sheraton);

    Room number1_2 = new Room();
    number1_2.setNumber(1);
    number1_2.setHotel(wildBear);
    Room number2_2 = new Room();
    number2_2.setNumber(2);
    number2_2.setHotel(wildBear);

    Room number1_3 = new Room();
    number1_3.setNumber(1);
    number1_3.setHotel(galaxy);
    Room number2_3 = new Room();
    number2_3.setNumber(2);
    number2_3.setHotel(galaxy);

    Room number1_4 = new Room();
    number1_4.setNumber(1);
    number1_4.setHotel(theD);
    Room number2_4 = new Room();
    number2_4.setNumber(2);
    number2_4.setHotel(theD);

    Room number1_5 = new Room();
    number1_5.setNumber(1);
    number1_5.setHotel(restup);
    Room number2_5 = new Room();
    number2_5.setNumber(2);
    number2_5.setHotel(restup);

    Room number1_6 = new Room();
    number1_6.setNumber(1);
    number1_6.setHotel(lewisham);
    Room number2_6 = new Room();
    number2_6.setNumber(2);
    number2_6.setHotel(lewisham);

    Room number1_7 = new Room();
    number1_7.setNumber(1);
    number1_7.setHotel(felix);
    Room number2_7 = new Room();
    number2_7.setNumber(2);
    number2_7.setHotel(felix);

    Room number1_8 = new Room();
    number1_8.setNumber(1);
    number1_8.setHotel(gonville);
    Room number2_8 = new Room();
    number2_8.setNumber(2);
    number2_8.setHotel(gonville);

    RoomBook roomBook1 = new RoomBook();
    roomBook1.setOrderStart("2019-01-06");
    roomBook1.setOrderEnd("2019-07-31");
    roomBook1.setClient(nazar);
    roomBook1.setRoom(number2_1);

    RoomBook roomBook2 = new RoomBook();
    roomBook2.setOrderStart("2019-07-03");
    roomBook2.setOrderEnd("2019-08-01");
    roomBook2.setClient(zakhar);
    roomBook2.setRoom(number1_1);

    RoomBook roomBook3 = new RoomBook();
    roomBook3.setOrderStart("2019-06-24");
    roomBook3.setOrderEnd("2019-09-15");
    roomBook3.setClient(alexandr);
    roomBook3.setRoom(number2_2);

    RoomBookArchive roomBookArchive1 = new RoomBookArchive();
    roomBookArchive1.setOrderStart("2019-01-23");
    roomBookArchive1.setOrderEnd("2019-03-25");
    roomBookArchive1.setClient(alexandr);
    roomBookArchive1.setRoom(number1_1);

    RoomBookArchive roomBookArchive2 = new RoomBookArchive();
    roomBookArchive2.setOrderStart("2019-01-10");
    roomBookArchive2.setOrderEnd("2019-02-15");
    roomBookArchive2.setClient(zakhar);
    roomBookArchive2.setRoom(number2_1);

    visaDao.add(jq);
    visaDao.add(britishTourist);

    clientDao.add(nazar);
    clientDao.add(zakhar);
    clientDao.add(alexandr);

    countryDao.add(usa);
    countryDao.add(england);

    cityDao.add(tennessee);
    cityDao.add(lasVegas);
    cityDao.add(london);
    cityDao.add(cambridge);

    hotelDao.add(sheraton);
    hotelDao.add(wildBear);
    hotelDao.add(galaxy);
    hotelDao.add(theD);
    hotelDao.add(restup);
    hotelDao.add(lewisham);
    hotelDao.add(felix);
    hotelDao.add(gonville);

    roomDao.add(number1_1);
    roomDao.add(number2_1);
    roomDao.add(number1_2);
    roomDao.add(number2_2);
    roomDao.add(number1_3);
    roomDao.add(number2_3);
    roomDao.add(number1_4);
    roomDao.add(number2_4);
    roomDao.add(number1_5);
    roomDao.add(number2_5);
    roomDao.add(number1_6);
    roomDao.add(number2_6);
    roomDao.add(number1_7);
    roomDao.add(number2_7);
    roomDao.add(number1_8);
    roomDao.add(number2_8);

    roomBookDao.add(roomBook1);
    roomBookDao.add(roomBook2);
    roomBookDao.add(roomBook3);

    roomBookArchiveDao.add(roomBookArchive1);
    roomBookArchiveDao.add(roomBookArchive2);
  }
}
