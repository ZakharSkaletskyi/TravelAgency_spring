package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.entity.Visa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VisaDaoImpl {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Visa visa) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(visa);
    }

    public Visa getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Visa.class, id);
    }
}
