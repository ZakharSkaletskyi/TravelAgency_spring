package museum.service;

import museum.dto.request.excursion.ExcursionRequestDto;
import museum.dto.request.excursion.ExcursionSaveDtoRequest;
import museum.dto.request.excursion.ExcursionUpdateDtoRequest;
import museum.dto.response.excursion.ExcursionResponse;
import museum.entity.Excursion;

import java.time.LocalDateTime;
import java.util.List;

public interface ExcursionService {

  void save(ExcursionSaveDtoRequest excursionSaveDtoRequest);

  List<ExcursionResponse> findAll();

  Excursion findById(Long id);

  void update(ExcursionUpdateDtoRequest excursionUpdateDtoRequest);

  void deleteById(Long id);

  List<ExcursionResponse> findByPeriod(LocalDateTime start, LocalDateTime end);

  Integer findCountByPeriod(LocalDateTime start, LocalDateTime end);
}
