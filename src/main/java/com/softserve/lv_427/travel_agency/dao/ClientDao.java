package com.softserve.lv_427.travel_agency.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.entity.Country;

public interface ClientDao {
  public List<Client> getAllClient();

  public void setSessionFactory(SessionFactory sessionFactory);

  public void add(Client client);

  public Client getById(int id);

  public void delete(Client client);

  public void edit(Client client);

  public int getClientId(String firstName, String lastName)
      throws SQLException, ClassNotFoundException, SQLException;

  public Client getClient(int id) throws SQLException, ClassNotFoundException;

  List<Country> getAvailableCountries(int clientId) throws ClassNotFoundException;
}
