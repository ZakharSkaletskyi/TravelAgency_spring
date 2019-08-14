package museum.dao;

import museum.dto.response.exhibit.ExhibitMaterialStat;
import museum.dto.response.exhibit.ExhibitTechnologyStat;
import museum.entity.Exhibit;

import java.util.List;

public interface ExhibitDao extends ElementDao<Exhibit> {
    List<ExhibitMaterialStat> getMaterialStat();

    List<ExhibitTechnologyStat> getTechnologyStat();
}
