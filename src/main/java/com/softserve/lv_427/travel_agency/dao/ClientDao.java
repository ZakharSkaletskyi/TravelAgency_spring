package com.softserve.lv_427.travel_agency.dao;

import com.softserve.lv_427.travel_agency.entity.Client;

public interface ClientDao {
  void add(Client client);

  Client getById(int id);

  void delete(Client client);

  void edit(Client client);
}
