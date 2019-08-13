package com.softserve.lv_427.travel_agency.dto;

import com.softserve.lv_427.travel_agency.entity.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CountryDto {
    private String name;
    private List<City> cities;
}
