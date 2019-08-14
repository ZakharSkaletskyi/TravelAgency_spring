package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.ExcursionDao;
import museum.dto.response.excursion.ExcursionResponse;
import museum.entity.Excursion;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Repository for Excursion logic.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Repository
public class ExcursionDaoImpl extends ElementDaoImpl<Excursion> implements ExcursionDao {
  public ExcursionDaoImpl() {
    super(Excursion.class);
  }

  @PersistenceContext private EntityManager manager;

  /**
   * Method for searching excursions in time period based on given input.
   *
   * @param start start of time slot to search in
   * @param end end of time slot to search in
   * @return List of ExcursionResponse.
   */
  @Override
  public List<ExcursionResponse> findByPeriod(LocalDateTime start, LocalDateTime end) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String query1 = "select e from Excursion e where e.begin >= :begin and e.end <= :end";
    TypedQuery query =
        manager
            .createQuery(query1, Excursion.class)
            .setParameter("begin", start)
            .setParameter("end", end);
    List<ExcursionResponse> excursions = query.getResultList();
    return excursions;
  }

  /**
   * Method for counting excursions in time period based on given input.
   *
   * @param start start of time slot to search in
   * @param end end of time slot to search in
   * @return int count of excursions.
   */
  @Override
  public Integer findCountByPeriod(LocalDateTime start, LocalDateTime end) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String string = "select count(e) from Excursion e where e.begin >= :begin and e.end <= :end";
    TypedQuery<Long> query =
        manager
            .createQuery(string, Long.class)
            .setParameter("begin", start)
            .setParameter("end", end);
    Long countL = query.getSingleResult();
    Integer count = countL.intValue();
    return count;
  }
}
