package museum.service;

import museum.dto.request.exhibit.ExhibitSaveDtoRequest;
import museum.dto.request.exhibit.ExhibitUpdateDtoRequest;
import museum.dto.response.exhibit.ExhibitDtoResponse;
import museum.dto.response.exhibit.ExhibitIdNameDtoResponse;
import museum.dto.response.exhibit.ExhibitMaterialStat;
import museum.dto.response.exhibit.ExhibitTechnologyStat;
import museum.entity.Exhibit;

import java.util.List;

public interface ExhibitService {
  void save(ExhibitSaveDtoRequest dto);

  List<ExhibitIdNameDtoResponse> findAll();

  ExhibitDtoResponse findById(Long id);

  Exhibit getOneById(Long id);

  void update(ExhibitUpdateDtoRequest dto);

  void deleteById(Long id);

  List<ExhibitMaterialStat> getMaterialStat();

  List<ExhibitTechnologyStat> getTechnologyStat();
}
