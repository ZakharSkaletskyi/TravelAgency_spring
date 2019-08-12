package com.softserve.lv_427.travel_agency.dto;

import java.util.ArrayList;
import java.util.List;

public class HotelRoomsIdDto {
	int hotelId;
	List<Integer> roomsId;
	HotelRoomsIdDto(int hotelId){
		this.hotelId=hotelId;
		roomsId=new ArrayList<Integer>();
	}
	
}
