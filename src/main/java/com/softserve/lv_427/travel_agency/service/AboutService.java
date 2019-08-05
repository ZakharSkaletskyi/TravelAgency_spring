package com.softserve.lv_427.travel_agency.service;

import com.softserve.lv_427.travel_agency.dto.AboutDto;

import java.sql.SQLException;

public interface AboutService {
  AboutDto getAboutDto() throws SQLException;
}
