package museum.service.impl;

import museum.dao.ExcursionDao;
import museum.dto.request.excursion.ExcursionSaveDtoRequest;
import museum.dto.request.excursion.ExcursionUpdateDtoRequest;
import museum.dto.response.excursion.ExcursionResponse;
import museum.entity.Excursion;
import museum.exception.BadIdException;
import museum.service.ExcursionService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for Excursion logic.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Service
public class ExcursionServiceImpl implements ExcursionService {

  @Autowired private ExcursionDao excursionDao;

  @Autowired private WorkerService workerService;

  /** Method that save new excursion. */
  @Transactional
  @Override
  public void save(ExcursionSaveDtoRequest dtoRequest) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    LocalDateTime begin = LocalDateTime.parse(dtoRequest.getBegin().replace("T", " "), formatter);

    LocalDateTime end = LocalDateTime.parse(dtoRequest.getEnd().replace("T", " "), formatter);

    Excursion excursion = new Excursion();
    excursion.setBegin(begin);
    excursion.setEnd(end);
    excursion.setPrice(dtoRequest.getPrice());
    excursion.setWorker(workerService.getOneById(dtoRequest.getWorkerId()));
    excursionDao.save(excursion);
  }

  /**
   * Method that return all excursion dto.
   *
   * @return List of ExcursionResponse.
   */
  @Transactional
  @Override
  public List<ExcursionResponse> findAll() {
    return excursionDao.findAll().stream().map(ExcursionResponse::new).collect(Collectors.toList());
  }

  /**
   * Method that return excursion by id.
   *
   * @return Excursion - this is entity.
   */
  @Transactional
  @Override
  public Excursion findById(Long id) {
    if (excursionDao == null) {
      throw new BadIdException("Excursion with id " + id + " does not exists");
    }
    return excursionDao.findById(id);
  }

  /** Method that update excursion. */
  @Transactional
  @Override
  public void update(ExcursionUpdateDtoRequest dtoRequest) {
    Excursion excursion = new Excursion();
    excursion.setId(dtoRequest.getId());
    excursion.setBegin(dtoRequest.getBegin());
    excursion.setEnd(dtoRequest.getEnd());
    excursion.setPrice(dtoRequest.getPrice());
    excursion.setWorker(workerService.getOneById(dtoRequest.getWorkerId()));
    Excursion newExcursion = excursionDao.update(excursion);
    if (newExcursion == null) {
      throw new BadIdException("Excursion has no any row with id " + dtoRequest.getId());
    }
  }

  /** Method that delete excursion by id. */
  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = excursionDao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Hall has not row with id " + id);
    }
  }

  /**
   * Method for searching excursions in time period based on given input.
   *
   * @param start start of time slot to search in
   * @param end end of time slot to search in
   * @return List of ExcursionResponse
   * @exception IllegalArgumentException
   */
  @Transactional
  @Override
  public List<ExcursionResponse> findByPeriod(LocalDateTime start, LocalDateTime end) {
    if (start != null && end != null) {
      if (start.isBefore(end)) {
        return excursionDao.findByPeriod(start, end);
      } else {
        throw new IllegalArgumentException("Second date value has to be bigger.");
      }
    } else {
      throw new IllegalArgumentException("Date must have a value and not to be null.");
    }
  }

  /**
   * Method for statistic excursions in time period based on given input.
   *
   * @param start start of time slot to search in
   * @param end end of time slot to search in
   * @return int count
   */
  @Transactional
  @Override
  public Integer findCountByPeriod(LocalDateTime start, LocalDateTime end) {
    int excursions = excursionDao.findCountByPeriod(start, end);
    return excursions;
  }
}
