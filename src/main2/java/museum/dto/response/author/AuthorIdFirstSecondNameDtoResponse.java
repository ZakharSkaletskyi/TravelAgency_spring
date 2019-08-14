package museum.dto.response.author;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Author;

@Getter
@Setter
public class AuthorIdFirstSecondNameDtoResponse {
  private Long id;

  private String firstName;

  private String secondName;

  public AuthorIdFirstSecondNameDtoResponse(Author author) {
    this.id = author.getId();
    this.firstName = author.getFirstName();
    this.secondName = author.getSecondName();
  }
}
