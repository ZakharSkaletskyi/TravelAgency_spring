package museum.dao;

import museum.dto.response.excursion.ExcursionResponse;
import museum.entity.Excursion;

import java.time.LocalDateTime;
import java.util.List;

public interface ExcursionDao extends ElementDao<Excursion> {

  List<ExcursionResponse> findByPeriod(LocalDateTime start, LocalDateTime end);

  Integer findCountByPeriod(LocalDateTime start, LocalDateTime end);
}
