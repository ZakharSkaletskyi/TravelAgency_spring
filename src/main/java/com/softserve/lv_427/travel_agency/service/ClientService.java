package com.softserve.lv_427.travel_agency.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.softserve.lv_427.travel_agency.dto.CityDto;
import com.softserve.lv_427.travel_agency.dto.ClientPeriodDto;
import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.entity.Country;

public interface ClientService {

  Client getById(int id);

  void add(Client client);

  List<Client> getAllClients();

  int getClientId(String firstName, String lastName) throws SQLException, ClassNotFoundException;

  Client getClient(int id) throws SQLException, ClassNotFoundException;

  void delete(Client client);

  void edit(Client client);

  List<Country> getAvailableCountries(int clientId) throws ClassNotFoundException;

  CityDto getCityDto(int cityId);

 // ClientPeriodDto getClientPeriodDto(int clientId, LocalDate dateStart, LocalDate dateEnd);

ClientPeriodDto getClientPeriodDto(int clientId,String dateStart,String dateEnd);
}
