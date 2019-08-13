package com.softserve.lv_427.travel_agency.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindHotelDto {
  private int hotelId;
  private String name;
  private int roomsCount;
  private List<Integer> avaibleRoomsNumber;
  private String dateStart;
  private String dateEnd;
}
