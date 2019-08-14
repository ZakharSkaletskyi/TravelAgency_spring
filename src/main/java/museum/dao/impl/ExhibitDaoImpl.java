package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.ExhibitDao;
import museum.dto.response.exhibit.ExhibitMaterialStat;
import museum.dto.response.exhibit.ExhibitTechnologyStat;
import museum.entity.Exhibit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository for Exhibit logic.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Repository
public class ExhibitDaoImpl extends ElementDaoImpl<Exhibit> implements ExhibitDao {
  @Autowired private EntityManager manager;

  public ExhibitDaoImpl() {
    super(Exhibit.class);
  }

  /**
   * Method for Exhibit material statistic.
   *
   * @return List of ExhibitMaterialStat
   */
  @Override
  public List<ExhibitMaterialStat> getMaterialStat() {
    List<Object[]> resultList =
        manager
            .createNativeQuery("select material, count(material) from exhibit group by material")
            .getResultList();

    List<ExhibitMaterialStat> exhibitTechnologyStats = new ArrayList<>();
    for (Object[] a : resultList) {
      exhibitTechnologyStats.add(
          new ExhibitMaterialStat(a[0].toString(), ((BigInteger) a[1]).longValue()));
    }
    return exhibitTechnologyStats;
  }

  /**
   * Method for Exhibit technology statistic.
   *
   * @return List of ExhibitMaterialStat
   */
  @Override
  public List<ExhibitTechnologyStat> getTechnologyStat() {

    List<Object[]> resultList =
        manager
            .createNativeQuery(
                "select technology, count(technology) from exhibit group by technology")
            .getResultList();

    List<ExhibitTechnologyStat> exhibitTechnologyStats = new ArrayList<>();
    for (Object[] a : resultList) {
      exhibitTechnologyStats.add(
          new ExhibitTechnologyStat(a[0].toString(), ((BigInteger) a[1]).longValue()));
    }
    return exhibitTechnologyStats;
  }
}
