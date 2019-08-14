package museum.service;

import museum.dto.request.author.AuthorUpdateDtoRequest;
import museum.dto.request.hall.HallSaveRequest;
import museum.dto.request.hall.HallUpdateRequest;
import museum.dto.response.hall.HallDtoResponse;
import museum.dto.response.hall.HallIdNameDtoResponse;
import museum.entity.Hall;

import java.util.List;

public interface HallService {
    void save(HallSaveRequest dto);

    List<HallIdNameDtoResponse> findAll();

    HallDtoResponse findById(Long id);

    Hall getOneById(Long id);

    void update(HallUpdateRequest dto);

    void deleteById(Long id);

    List<HallDtoResponse> findByWorkerId(Long id);
}
