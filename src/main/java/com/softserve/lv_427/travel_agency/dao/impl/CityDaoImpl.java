package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.entity.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDaoImpl {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(City city) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(city);
    }

    public City getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(City.class, id);
    }
}
