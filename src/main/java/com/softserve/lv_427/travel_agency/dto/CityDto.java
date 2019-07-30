package com.softserve.lv_427.travel_agency.dto;

import com.softserve.lv_427.travel_agency.entity.Hotel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CityDto {
    private String name;
    private String countryName;
    private List<Hotel> hotels;
}
