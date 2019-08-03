package com.softserve.lv_427.travel_agency.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softserve.lv_427.travel_agency.dto.ProfileClientDTO;
import com.softserve.lv_427.travel_agency.service.CountryService;
import com.softserve.lv_427.travel_agency.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.lv_427.travel_agency.dao.ClientDao;
import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
  private ClientDao dao;
  private final VisaService visaService;
  private final CountryService countryService;

  @Autowired
  public ClientServiceImpl(ClientDao dao, VisaService visaService, CountryService countryService) {
    this.dao = dao;
    this.visaService = visaService;
    this.countryService = countryService;
  }

  @Override
  @Transactional
  public Client getById(int id) {
    return dao.getById(id);
  }

  @Override
  @Transactional
  public void add(Client client) {
    dao.add(client);
  }

  @Override
  @Transactional
  public void delete(Client client) {
    dao.delete(client);
  }

  @Override
  public void edit(Client client) {
    dao.edit(client);
  }

  @Override
  @Transactional
  public List<Client> getAllClients() {
    return dao.getAllClient();
  }

  @Override
  @Transactional
  public int getClientId(String firstName, String lastName)
      throws SQLException, ClassNotFoundException {
    return dao.getClientId(firstName, lastName);
  }

  @Override
  @Transactional
  public Client getClient(int id) throws SQLException, ClassNotFoundException {
    return dao.getClient(id);
  }

  @Override
  @Transactional
  public List<Country> getAvailableCountries(int clientId) throws ClassNotFoundException {
    return dao.getAvailableCountries(clientId);
  }

  @Override
  @Transactional
  public int getCountOfClients() {
    return dao.getCountOfClients();
  }

  @Override
  @Transactional
  public ProfileClientDTO getProfileClientDTO(int clientID) throws ClassNotFoundException, SQLException
  {
    ProfileClientDTO profileClientDTO = new ProfileClientDTO();
    Client client = getClient(clientID);
    profileClientDTO.setFirstName(client.getFirstName());
    profileClientDTO.setLastName(client.getLastName());
    profileClientDTO.setPhoneNumber(client.getPhoneNumber());
    profileClientDTO.setCountries(countryService.getVisitedCountries(clientID));
    profileClientDTO.setVisas(visaService.getVisasForTheClient(clientID));

    return  profileClientDTO;
  }
}
