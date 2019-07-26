package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.entity.RoomBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomBookDaoImpl {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(RoomBook roomBook) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(roomBook);
    }

    public RoomBook getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(RoomBook.class, id);
    }
}
