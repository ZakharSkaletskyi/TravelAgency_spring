package com.softserve.lv_427.travel_agency.service;

import java.sql.SQLException;
import java.util.List;

import com.softserve.lv_427.travel_agency.entity.Visa;

public interface VisaService {

  int getId(String name) throws SQLException, ClassNotFoundException;

  int getVisasCountForTheClient(int clientId) throws SQLException;

List<Visa> getVisasForTheClient(int clientId) throws SQLException,ClassNotFoundException;

int CountVisaForCountry(int countryId) throws SQLException;
}
