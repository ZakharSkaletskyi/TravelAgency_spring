package com.softserve.lv_427.travel_agency.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindHotelDto {
  int hotelID; // ////////
  String name;
  int roomsCount; // �-��� �����: <b><%=roomService.getRoomCount
  List<Integer> avaibleRoomsNumber; // ������� ������
  String dateStart; // book///////
  String dateEnd; // book////////
}
