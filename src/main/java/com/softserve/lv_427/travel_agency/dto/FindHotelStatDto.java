package com.softserve.lv_427.travel_agency.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindHotelStatDto {
  private int hotelId;
  private String startDateHotelStat;
  private String endDateHotelStat;
  private int clientsCountsForPeriod;
  private int AverageBookTimeForPeriod;
  private List<Integer> roomsLoadingForPeriod;
}
