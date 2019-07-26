package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDaoImpl {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(hotel);
    }

    public Hotel getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Hotel.class, id);
    }
}
