package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.VisaDao;
import com.softserve.lv_427.travel_agency.entity.Visa;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VisaDaoImpl implements VisaDao {
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void add(Visa visa) {
    try (Session session = sessionFactory.openSession()) {
      session.persist(visa);
    }
  }

  @Override
  public Visa getById(int id) {
    try (Session session = sessionFactory.openSession()) {
      return session.get(Visa.class, id);
    }
  }

  @Override
  public void delete(Visa visa) {
    try (Session session = sessionFactory.openSession()) {
      session.delete(visa);
    }
  }

  @Override
  public void edit(Visa visa) {
    try (Session session = sessionFactory.openSession()) {
      session.update(visa);
    }
  }

  @Override
  public List<Visa> findAll() {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery("FROM Visa", Visa.class).list();
    }
  }

  @Override
  public int getId(String name) throws SQLException, ClassNotFoundException {
    try (Session session = sessionFactory.openSession()) {
      Integer id =
          session
              .createQuery("SELECT id FROM Visa WHERE name = ?1", Integer.class)
              .setParameter(1, name)
              .uniqueResult();
      if (id == null) throw new ClassNotFoundException("In DB no Visa row with name=" + name);
      return id;
    }
  }

  @Override
  public int getVisasCountForTheClient(int clientId) throws SQLException {
    try (Session session = sessionFactory.openSession()) {
      Long count =
          session
              .createQuery(
                  "SELECT COUNT(v.id) FROM Visa v LEFT JOIN v.clients c WHERE c.id=?1", Long.class)
              .setParameter(1, clientId)
              .uniqueResult();

      return count.intValue();
    }
  }

  @Override
  public List<Visa> getVisasForTheClient(int clientId) throws SQLException, ClassNotFoundException {
    try (Session session = sessionFactory.openSession()) {
      List<Visa> visas =
          session
              .createQuery("SELECT v FROM Visa v LEFT JOIN v.clients c WHERE c.id=?1", Visa.class)
              .setParameter(1, clientId)
              .list();
      if (visas == null)
        throw new ClassNotFoundException("In DB no Visa row with client_id=" + clientId);
      return visas;
    }
  }

  @Override
  public int CountVisaForCountry(int countryId) throws SQLException {
    try (Session session = sessionFactory.openSession()) {
      Long count =
          session
              .createQuery(
                  "SELECT COUNT(c.id) FROM Client c JOIN c.visas v LEFT JOIN v.countries ctr WHERE ctr.id = ?1",
                  Long.class)
              .setParameter(1, countryId)
              .uniqueResult();

      return count.intValue();
    }
  }
}
