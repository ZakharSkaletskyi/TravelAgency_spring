package com.softserve.lv_427.travel_agency.dto.hotel;

import com.softserve.lv_427.travel_agency.entity.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelWithAvailabilityDto {
    String hotelName;
    String currentDate;
    String startDate;
    String endDate;
    List<Room> availableRooms;
}
