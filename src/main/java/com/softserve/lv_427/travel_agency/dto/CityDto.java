package com.softserve.lv_427.travel_agency.dto;

import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CityDto {
    private String name;
    private Country country;
    private List<Hotel> hotels;
}
