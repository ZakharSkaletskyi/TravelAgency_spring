package museum.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * This class is Data Access Object that can cooperate with any entities because of generic.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
public class ElementDaoImpl<T> implements ElementDao<T> {

  @PersistenceContext private EntityManager manager;

  private Class<T> elementClass;

  public ElementDaoImpl(Class<T> elementClass) {
    this.elementClass = elementClass;
  }
  /**
   * Method that return list of Entities.
   *
   * @return List<T>, where T is generic of Entity.
   */
  @Override
  public List<T> findAll() {
    return manager
        .createQuery("from " + elementClass.getSimpleName() + " e", elementClass)
        .getResultList();
  }
  /**
   * Method that return Entity by id.
   *
   * @return T, where T is generic of Entity.
   */
  @Override
  public T findById(Long id) {
    return manager.find(elementClass, id);
  }

  /** Method that save Entity. */
  @Override
  public void save(T element) {
    manager.persist(element);
  }
  /**
   * Method that update Entity.
   *
   * @return T, where T is generic of Entity if exist.
   */
  @Override
  public T update(T element) {
    return manager.merge(element);
  }
  /**
   * Method that delete Entity by id.
   *
   * @return Boolean - true if row with current id is in DB.
   */
  @Override
  public Boolean deleteById(Long id) {
    T byId = findById(id);
    if (byId != null) {
      manager.remove(byId);
      return true;
    } else {
      return false;
    }
  }
}
