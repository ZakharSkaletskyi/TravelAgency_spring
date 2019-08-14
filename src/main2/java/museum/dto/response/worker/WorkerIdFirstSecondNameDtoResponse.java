package museum.dto.response.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Worker;

@Getter
@Setter
@NoArgsConstructor
public class WorkerIdFirstSecondNameDtoResponse {

  private Long id;

  private String firstName;

  private String secondName;

  public WorkerIdFirstSecondNameDtoResponse(Worker worker) {
    this.id = worker.getId();
    this.firstName = worker.getFirstName();
    this.secondName = worker.getSecondName();
  }
}
