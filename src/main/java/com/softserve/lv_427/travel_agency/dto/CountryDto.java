package com.softserve.lv_427.travel_agency.dto;

import com.softserve.lv_427.travel_agency.entity.City;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryDto {
    private String name;
    private List<City> cities;
}
