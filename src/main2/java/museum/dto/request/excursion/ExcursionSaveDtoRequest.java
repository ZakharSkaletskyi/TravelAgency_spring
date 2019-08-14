package museum.dto.request.excursion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcursionSaveDtoRequest {

  @NotNull private String begin;

  @NotNull private String end;

  @NotNull private Double price;

  @NotNull private Long workerId;

  public ExcursionSaveDtoRequest(Excursion excursion) {
    this.begin = excursion.getBegin().toString();
    this.end = excursion.getEnd().toString();
    this.price = excursion.getPrice();
    this.workerId = excursion.getWorker().getId();
  }
}
