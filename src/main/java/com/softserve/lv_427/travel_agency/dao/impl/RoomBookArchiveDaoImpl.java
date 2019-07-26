package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.entity.RoomBookArchive;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomBookArchiveDaoImpl {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(RoomBookArchive roomBookArchive) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(roomBookArchive);
    }

    public RoomBookArchive getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(RoomBookArchive.class, id);
    }
}
