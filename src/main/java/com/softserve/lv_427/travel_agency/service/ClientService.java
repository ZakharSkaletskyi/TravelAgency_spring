package com.softserve.lv_427.travel_agency.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import com.softserve.lv_427.travel_agency.entity.Client;

public interface ClientService {

Client getById(int id);

void add(Client client);

List<Client> getAllClients();

int getClientId(String firstName,String lastName) throws SQLException,ClassNotFoundException;

Client getClient(int id) throws SQLException,ClassNotFoundException;
}
