package com.softserve.lv_427.travel_agency.dto;

import com.softserve.lv_427.travel_agency.entity.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class HotelDto {
    int hotelId;
    String hotelName;
    String countryName;
    String cityName;
    String currentDate;
    String startDate;
    String endDate;
    List<Room> availableRooms;
    Integer countOfClient;
    Integer averageBookTime;
    List<Integer[]> roomLoading;
}
