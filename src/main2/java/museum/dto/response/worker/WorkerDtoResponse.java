package museum.dto.response.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.response.excursion.ExcursionBeginEndDtoResponse;
import museum.dto.response.hall.HallIdNameDtoResponse;
import museum.entity.Excursion;
import museum.entity.Hall;
import museum.entity.Worker;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO for Worker response.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class WorkerDtoResponse {

  private Long id;

  private String firstName;

  private String secondName;

  private Long postId;

  private List<HallIdNameDtoResponse> halls;
  private List<ExcursionBeginEndDtoResponse> excursions;

  /**
   * Constructor for class.
   *
   * @param worker object of post.
   */
  public WorkerDtoResponse(Worker worker) {
    this.id = worker.getId();
    this.firstName = worker.getFirstName();
    this.secondName = worker.getSecondName();
    this.postId = worker.getPost().getId();
    this.halls =
        worker.getHalls().stream().map(HallIdNameDtoResponse::new).collect(Collectors.toList());
    this.excursions =
        worker.getExcursions().stream()
            .map(ExcursionBeginEndDtoResponse::new)
            .collect(Collectors.toList());
    ;
  }
}
