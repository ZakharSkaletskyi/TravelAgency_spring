package com.softserve.lv_427.travel_agency.dto.hotel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelWithStatisticDto {
    String hotelName;
    String currentDate;
    String startDate;
    String endDate;
    Integer countOfClient;
    Integer averageBookTime;
    List<Integer[]> roomLoading;
}
