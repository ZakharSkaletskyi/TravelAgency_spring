package com.softserve.lv_427.travel_agency.dto;

import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.entity.Visa;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfileClientDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Country> countries;
    private List<Visa> visas;

}
