package com.softserve.lv_427.travel_agency.dao.impl;

import com.softserve.lv_427.travel_agency.dao.ClientDao;
import com.softserve.lv_427.travel_agency.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl implements ClientDao {
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public Client getById(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Client.class, id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Client> getAllClient() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("from Client").list();
  }

  @Override
  public void add(Client client) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(client);
  }

  @Override
  public void delete(Client client) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(client);
  }

  @Override
  public void edit(Client client) {
    Session session = sessionFactory.getCurrentSession();
    session.update(client);
  }
  /**
   * Method that find and return client id by his firstName and lastName.
   *
   * @param firstName - client first name
   * @param lastName - client last name
   * @return list of cities.
   * @exception SQLException - error in sql query.
   */
  @Override
  public int getClientId(String firstName, String lastName)
      throws SQLException, ClassNotFoundException {
    Session session = sessionFactory.getCurrentSession();
    return session
        .createQuery(
            "SELECT id FROM Client WHERE first_name = ?1 AND last_name = ?2", Integer.class)
        .setParameter(1, firstName)
        .setParameter(2, lastName)
        .uniqueResult();
  }

  /**
   * Method that find Client by id.
   *
   * @param id - client id
   * @return Client.
   * @exception SQLException - error in sql query.
   * @exception ClassNotFoundException - error if record in DB not found.
   */
  @Override
  public Client getClient(int id) throws SQLException, ClassNotFoundException {
    Session session = sessionFactory.getCurrentSession();
    Client client =
        session
            .createQuery("SELECT * FROM Client WHERE id = ?1", Client.class)
            .setParameter(1, id)
            .getResultList()
            .get(0);
    if (client == null) throw new ClassNotFoundException("In DB no row with id " + id);
    return client;
  }
}
