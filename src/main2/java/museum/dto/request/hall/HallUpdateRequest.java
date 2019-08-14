package museum.dto.request.hall;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor

public class HallUpdateRequest {

  private Long id;

  private String name;

  private Long workerId;
}
