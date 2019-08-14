package museum.dto.response.author;

import lombok.Getter;
import lombok.Setter;
import museum.dto.response.exhibit.ExhibitIdNameDtoResponse;
import museum.entity.Author;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AuthorDtoResponse {

  private Long id;

  private String firstName;

  private String secondName;

  private List<ExhibitIdNameDtoResponse> exhibits;

  public AuthorDtoResponse(Author author) {
    this.id = author.getId();
    this.firstName = author.getFirstName();
    this.secondName = author.getSecondName();
    this.exhibits =
        author.getExhibits().stream()
            .map(ExhibitIdNameDtoResponse::new)
            .collect(Collectors.toList());
  }
}
