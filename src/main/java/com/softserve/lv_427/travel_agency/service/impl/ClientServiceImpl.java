package com.softserve.lv_427.travel_agency.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.lv_427.travel_agency.dao.ClientDao;
import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
  private ClientDao clientDAO;

  @Autowired
  public ClientServiceImpl(ClientDao clientDAO) {
    this.clientDAO = clientDAO;
  }

  @Override
  @Transactional
  public Client getById(int id) {
    // TODO Auto-generated method stub
    return clientDAO.getById(id);
  }

  @Override
  @Transactional
  public void add(Client client) {
    // TODO Auto-generated method stub

  }

  @Override
  @Transactional
  public List<Client> getAllClients() {
    return clientDAO.getAllClient();
  }

  @Override
  @Transactional
  public int getClientId(String firstName, String lastName)
      throws SQLException, ClassNotFoundException {
    return clientDAO.getClientId(firstName, lastName);
  }

  @Override
  @Transactional
  public Client getClient(int id) throws SQLException, ClassNotFoundException {
    return clientDAO.getClient(id);
  }
}
