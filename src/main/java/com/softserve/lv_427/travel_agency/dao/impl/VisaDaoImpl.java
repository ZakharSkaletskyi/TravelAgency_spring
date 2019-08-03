package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.VisaDao;
import com.softserve.lv_427.travel_agency.entity.Country;
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
    Session session = sessionFactory.getCurrentSession();
    session.persist(visa);
  }

  @Override
  public Visa getById(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Visa.class, id);
  }

  @Override
  public void delete(Visa visa) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(visa);
  }

  @Override
  public void edit(Visa visa) {
    Session session = sessionFactory.getCurrentSession();
    session.update(visa);
  }

  @Override
  public List<Visa> findAll() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("from Visa", Visa.class).list();
  }

  @Override
  public int getId(String name) throws SQLException, ClassNotFoundException {
    Session session = sessionFactory.getCurrentSession();
    Integer id =
        session
            .createQuery("SELECT id FROM Visa WHERE visa_name = ?1", Integer.class)
            .setParameter(1, name)
            .uniqueResult();
    if (id == null) throw new ClassNotFoundException("In DB no Visa row with name=" + name);
    return id;
  }

  @Override
  public int getVisasCountForTheClient(int clientId) throws SQLException {
    Session session = sessionFactory.getCurrentSession();
    Long count =
        session
            .createQuery(
                "SELECT COUNT(v.id) FROM Visa v LEFT JOIN v.clients c WHERE c.id=?1", Long.class)
            .setParameter(1, clientId)
            .uniqueResult();

    return count.intValue();
  }

  @Override
  public List<Visa> getVisasForTheClient(int clientId) throws SQLException, ClassNotFoundException {
    Session session = sessionFactory.getCurrentSession();
    List<Visa> visas =
        session
            .createQuery("SELECT v FROM Visa v LEFT JOIN v.clients c WHERE c.id=?1", Visa.class)
            .setParameter(1, clientId)
            .list();
    if (visas == null)
      throw new ClassNotFoundException("In DB no Visa row with client_id=" + clientId);
    return visas;
  }

  @Override
  public int CountVisaForCountry(int countryId) throws SQLException {

    Session session = sessionFactory.getCurrentSession();
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
