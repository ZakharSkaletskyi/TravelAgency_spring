package museum.dto.response.exhibit;

import lombok.Getter;
import lombok.Setter;
import museum.dto.response.author.AuthorIdFirstSecondNameDtoResponse;
import museum.dto.response.hall.HallIdNameDtoResponse;
import museum.entity.Exhibit;

@Getter
@Setter
public class ExhibitDtoResponse {
  private Long id;

  private String name;

  private String material;

  private String technology;

  private AuthorIdFirstSecondNameDtoResponse author;

  private HallIdNameDtoResponse hall;

  public ExhibitDtoResponse(Exhibit exhibit) {
    this.id = exhibit.getId();
    this.name = exhibit.getName();
    this.material = exhibit.getMaterial();
    this.technology = exhibit.getTechnology();
    this.author = new AuthorIdFirstSecondNameDtoResponse(exhibit.getAuthor());
    this.hall = new HallIdNameDtoResponse(exhibit.getHall());
  }
}
