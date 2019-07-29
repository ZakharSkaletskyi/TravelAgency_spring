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
  private ClientDao dao;

  @Autowired
  public ClientServiceImpl(ClientDao dao) {
    this.dao = dao;
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
}
