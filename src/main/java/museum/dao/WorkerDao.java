package museum.dao;

import museum.dto.response.worker.WorkerDtoResponse;
import museum.entity.Worker;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DAO interface for Worker entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
public interface WorkerDao extends ElementDao<Worker> {

  /**
   * Gets worker id by name.
   *
   * @param name worker name.
   * @return id of worker.
   */
  Long findWorkerIdByName(String name);

  /**
   * Gets all free workers.
   *
   * @param date current date-time value.
   * @return List of free guides.
   */
  List<WorkerDtoResponse> findAllFreeGuide(LocalDateTime date);

  /**
   * Gets all guides.
   *
   * @return List of all worker with post gid.
   */
  List<Worker> findAllGuide();

  /**
   * Gets count of excursion of some guide.
   *
   * @param id worker id
   * @return count of excursion.
   */
  Integer findCountOfExcursion(Long id);

  /**
   * Gets count of all excursion hours of some guide.
   *
   * @param id worker id
   * @return count of excursion.
   */
  Integer findCountOfHours(Long id);
}
