package museum.dto.request.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Author;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorSaveDtoRequest {

  @NotBlank private String firstName;

  @NotBlank private String secondName;

  public AuthorSaveDtoRequest(Author author) {
    this.firstName = author.getFirstName();
    this.secondName = author.getSecondName();
  }
}
