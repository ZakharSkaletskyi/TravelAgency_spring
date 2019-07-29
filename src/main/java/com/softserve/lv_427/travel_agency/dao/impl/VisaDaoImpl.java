package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.VisaDao;
import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.entity.Visa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VisaDaoImpl implements VisaDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory)  {
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
  public int getId(String name) throws SQLException, ClassNotFoundException {
    	 Session session = sessionFactory.getCurrentSession();
    	 Integer id=
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
    	 Integer count=
    	            session
    	                .createQuery("SELECT COUNT(ID) FROM Visa WHERE client_Id = ?1", Integer.class)
    	                .setParameter(1, clientId)
    	                .uniqueResult();
  if (count == null) return 0;
  return count;
    }

    @Override
    public List<Visa> getVisasForTheClient(int clientId) throws SQLException, ClassNotFoundException {
    	 Session session = sessionFactory.getCurrentSession();
    	 List<Visa> visas=
    	            session
    	                .createQuery("FROM visa WHERE Visa.id IN (SELECT visa_id FROM client_visa WHERE client_id = ?1)", Visa.class)
    	                .setParameter(1, clientId)
    	                .list();
  if (visas == null) throw new ClassNotFoundException("In DB no Visa row with client_id=" + clientId);
     return visas;
    }
  
//    @Override
//    public int CountVisaForCountry(int countryId) throws SQLException {
//    	 Session session = sessionFactory.getCurrentSession();
//    	 Integer count=
//    	            session
//    	                .createQuery("SELECT COUNT(id) FROM visa AS COUNT WHERE COUNTRY_ID = ?1", Integer.class)
//    	                .setParameter(1, countryId)
//    	                .uniqueResult();
//  if (count == null) return 0;
//      return count;
//    }
}
