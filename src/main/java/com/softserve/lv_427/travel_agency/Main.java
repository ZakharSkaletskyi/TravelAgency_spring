package com.softserve.lv_427.travel_agency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.lv_427.travel_agency.dao.ClientDao;
import com.softserve.lv_427.travel_agency.dao.impl.ClientDaoImpl;
import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.service.ClientService;
import com.softserve.lv_427.travel_agency.service.impl.ClientServiceImpl;

public class Main {
//    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/Travel_Agency?useSSH=false&&serverTimezone=UTC";
//        String username = "root";
//        String password = "root";
//        System.out.println("Connecting...");
//
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            System.out.println("Connection successful!");
//        } catch (SQLException e) {
//            System.out.println("Connection failed!");
//            e.printStackTrace();
//        }
//    }
    private SessionFactory sessionFactory;
    @Autowired private ClientService clientService;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
  public static void main(String[] args) {
//	  Session s = sessionFactory.getCurrentSession();
//	
//      Session session = null;
//      try {
//          session = HibernateUtil.getSessionFactory().openSession();
//          Transaction transaction = session.beginTransaction();
//          session.delete(element);
//          transaction.commit();
//      } finally {
//           if ((session != null) && (session.isOpen())) {
//                session.close();
//       }    }

      
//    // TODO Auto-generated method stub
//      Session session = sessionFactory.getCurrentSession();
//
//	  ClientDao dao= new ClientDaoImpl();
//	  ClientService serv =new ClientServiceImpl();
//	  System.out.println("ClientDao: "+dao.toString());
//	  System.out.println("Client Service"+serv.getAllClients());
  }
}
