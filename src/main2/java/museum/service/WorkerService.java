package museum.service;

import museum.dto.request.worker.WorkerAddRequestDto;
import museum.dto.request.worker.WorkerUpdateRequestDto;
import museum.dto.response.worker.WorkerDtoResponse;
import museum.dto.response.worker.WorkerFirstSecondNameDtoResponse;
import museum.dto.response.worker.WorkerStatDtoResponse;
import museum.entity.Worker;

import java.util.List;

/**
 * Service interface for Worker entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
public interface WorkerService {

  /**
   * Save worker.
   *
   * @param workerAddRequestDto request worker dto.
   */
  void save(WorkerAddRequestDto workerAddRequestDto);

  /**
   * Get all workers.
   *
   * @return List of workerFirstSecondNameDtoResponse;
   */
  List<WorkerFirstSecondNameDtoResponse> findAll();

  /**
   * Get worker by id.
   *
   * @param id worker id.
   * @return worker;
   */
  Worker findById(Long id);

  /**
   * Get worker id by name.
   *
   * @param name worker name.
   * @return id of worker;
   */
  Long findWorkerIdByName(String name);

  /**
   * Get all free guides.
   *
   * @return List of WorkerDtoResponse;
   */
  List<WorkerDtoResponse> findAllFreeGuide();

  /**
   * Get all guides.
   *
   * @return List of WorkerDtoResponse;
   */
  List<WorkerDtoResponse> findAllGuide();

  /**
   * Get guides statistic.
   *
   * @return List of WorkerStatDtoResponse;
   */
  List<WorkerStatDtoResponse> findGuidesStat();

  /**
   * Delete worker by id.
   *
   * @param id worker id.
   */
  void deleteById(Long id);

  /**
   * Get worker by id..
   *
   * @return Worker;
   */
  Worker getOneById(Long id);

  /**
   * Update worker info.
   *
   * @param workerUpdateRequestDto request worker dto.
   */
  void update(WorkerUpdateRequestDto workerUpdateRequestDto);
}
