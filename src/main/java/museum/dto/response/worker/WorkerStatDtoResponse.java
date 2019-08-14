package museum.dto.response.worker;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * DTO for Worker statistic response.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
public class WorkerStatDtoResponse {

  private Long id;

  private String firstName;

  private String secondName;

  private int countOfExcursion;

  private int countOfHour;
}
