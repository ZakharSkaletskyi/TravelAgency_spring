package museum.service.impl;

import museum.dao.WorkerDao;
import museum.dto.request.worker.WorkerAddRequestDto;
import museum.dto.request.worker.WorkerUpdateRequestDto;
import museum.dto.response.worker.WorkerDtoResponse;
import museum.dto.response.worker.WorkerFirstSecondNameDtoResponse;
import museum.dto.response.worker.WorkerStatDtoResponse;
import museum.entity.Worker;
import museum.exception.BadIdException;
import museum.exception.BadNameException;
import museum.service.PostService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for Worker entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Service
public class WorkerServiceImpl implements WorkerService {

  @Autowired private WorkerDao workerDao;

  @Autowired private PostService postService;

  /**
   * Save worker.
   *
   * @param workerAddRequestDto request worker dto.
   */
  @Transactional
  @Override
  public void save(WorkerAddRequestDto workerAddRequestDto) {
    workerDao.save(workerAddRequestDtoToWorker(workerAddRequestDto));
  }

  /**
   * Get all workers.
   *
   * @return List of workerFirstSecondNameDtoResponse;
   */
  @Transactional
  @Override
  public List<WorkerFirstSecondNameDtoResponse> findAll() {
    List<Worker> workers = workerDao.findAll();
    return workers.stream().map(WorkerFirstSecondNameDtoResponse::new).collect(Collectors.toList());
  }

  /**
   * Get worker by id.
   *
   * @param id worker id.
   * @return worker;
   */
  @Transactional
  @Override
  public Worker findById(Long id) {
    Worker worker = workerDao.findById(id);
    return worker;
  }

  /**
   * Get worker id by name.
   *
   * @param name worker name.
   * @return id of worker;
   */
  @Transactional
  @Override
  public Long findWorkerIdByName(String name) {
    try {
      return workerDao.findWorkerIdByName(name);
    } catch (NoResultException e) {
      throw new BadNameException("Worker with name " + name + " doesn't exist");
    }
  }

  /**
   * Get all free guides.
   *
   * @return List of WorkerDtoResponse;
   */
  @Transactional
  @Override
  public List<WorkerDtoResponse> findAllFreeGuide() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.now();
    List<WorkerDtoResponse> workers = workerDao.findAllFreeGuide(dateTime);
    return workers;
  }

  /**
   * Get all guides.
   *
   * @return List of WorkerDtoResponse;
   */
  @Transactional
  @Override
  public List<WorkerDtoResponse> findAllGuide() {
    List<Worker> workers = workerDao.findAllGuide();
    return workers.stream().map(WorkerDtoResponse::new).collect(Collectors.toList());
  }

  /**
   * Get guides statistic.
   *
   * @return List of WorkerStatDtoResponse;
   */
  @Transactional
  @Override
  public List<WorkerStatDtoResponse> findGuidesStat() {
    List<Worker> workers = workerDao.findAllGuide();
    List<WorkerStatDtoResponse> workerStatDtoResponses = new ArrayList<>();
    for (Worker worker : workers) {
      workerStatDtoResponses.add(workerToWorkerStatDto(worker));
    }
    return workerStatDtoResponses;
  }

  /**
   * Delete worker by id.
   *
   * @param id worker id.
   */
  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = workerDao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Worker with entered id doesn't exist");
    }
  }

  /**
   * Get worker by id..
   *
   * @return Worker;
   */
  @Transactional
  @Override
  public Worker getOneById(Long id) {
    Worker worker = workerDao.findById(id);
    if (worker == null) {
      throw new BadIdException("Worker with id " + id + " doesn't exist");
    }
    return worker;
  }

  /**
   * Update worker info.
   *
   * @param worker request worker dto.
   */
  @Transactional
  @Override
  public void update(WorkerUpdateRequestDto worker) {
    workerDao.update(workerUpdateRequestDtoToWorker(worker));
  }

  /**
   * Mapper from Worker to WorkerStatDto.
   *
   * @param worker worker object.
   * @return workerStatDtoResponse response dto.
   */
  private WorkerStatDtoResponse workerToWorkerStatDto(Worker worker) {
    WorkerStatDtoResponse workerStatDtoResponse = new WorkerStatDtoResponse();
    workerStatDtoResponse.setId(worker.getId());
    workerStatDtoResponse.setFirstName(worker.getFirstName());
    workerStatDtoResponse.setSecondName(worker.getSecondName());
    workerStatDtoResponse.setCountOfHour(workerDao.findCountOfHours(worker.getId()));
    workerStatDtoResponse.setCountOfExcursion(workerDao.findCountOfExcursion(worker.getId()));
    return workerStatDtoResponse;
  }

  /**
   * Mapper from WorkerAddRequestDto to Worker.
   *
   * @param workerAddRequestDto worker request dto.
   * @return Worker.
   */
  private Worker workerAddRequestDtoToWorker(WorkerAddRequestDto workerAddRequestDto) {
    Worker worker = new Worker();
    worker.setFirstName(workerAddRequestDto.getFirstName());
    worker.setSecondName(workerAddRequestDto.getSecondName());
    worker.setPost(postService.getOneById(workerAddRequestDto.getPostId()));
    return worker;
  }

  /**
   * Mapper from WorkerUpdateRequestDto to Worker.
   *
   * @param workerUpdateRequestDto worker request dto.
   * @return workerStatDtoResponse response dto.
   */
  private Worker workerUpdateRequestDtoToWorker(WorkerUpdateRequestDto workerUpdateRequestDto) {
    Worker worker = new Worker();
    worker.setId(workerUpdateRequestDto.getId());
    worker.setFirstName(workerUpdateRequestDto.getFirstName());
    worker.setSecondName(workerUpdateRequestDto.getSecondName());
    worker.setPost(postService.getOneById(workerUpdateRequestDto.getPostId()));
    return worker;
  }
}
