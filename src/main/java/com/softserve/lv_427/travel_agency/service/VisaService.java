package com.softserve.lv_427.travel_agency.service;

import java.sql.SQLException;

public interface VisaService {

  int getId(String name) throws SQLException, ClassNotFoundException;

  int getVisasCountForTheClient(int clientId) throws SQLException;
}
