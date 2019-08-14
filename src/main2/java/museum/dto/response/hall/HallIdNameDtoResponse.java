package museum.dto.response.hall;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Hall;

@Getter
@Setter
public class HallIdNameDtoResponse {

  private Long id;

  private String name;

  public HallIdNameDtoResponse(Hall hall) {
    this.id = hall.getId();
    this.name = hall.getName();
  }
}
