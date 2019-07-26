package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDaoImpl {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(room);
    }

    public Room getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Room.class, id);
    }
}
