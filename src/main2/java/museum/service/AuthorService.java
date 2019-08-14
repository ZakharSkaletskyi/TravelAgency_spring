package museum.service;

import museum.dto.request.author.AuthorSaveDtoRequest;
import museum.dto.request.author.AuthorUpdateDtoRequest;
import museum.dto.response.author.AuthorDtoResponse;
import museum.dto.response.author.AuthorIdFirstSecondNameDtoResponse;
import museum.entity.Author;

import java.util.List;

public interface AuthorService {

  void save(AuthorSaveDtoRequest dto);

  List<AuthorIdFirstSecondNameDtoResponse> findAll();

  AuthorDtoResponse findById(Long id);

  Author getOneById(Long id);

  void update(AuthorUpdateDtoRequest dto);

  void deleteById(Long id);
}
