package museum.dto.request.hall;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Hall;

@Getter
@Setter
@NoArgsConstructor
public class HallSaveRequest {

  private Long id;

  private String name;

  private Long workerId;

  public HallSaveRequest(Hall hall) {
    this.id = hall.getId();
    this.name = hall.getName();
    this.workerId = hall.getWorker().getId();
  }
}
