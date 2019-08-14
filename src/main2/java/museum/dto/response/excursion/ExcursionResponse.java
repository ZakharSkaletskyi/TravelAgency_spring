package museum.dto.response.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ExcursionResponse {

    private Long id;

    private LocalDateTime begin;

    private LocalDateTime end;

    private Double price;

    private String workerFirstName;

    private String workerSecondName;

    public ExcursionResponse(Excursion excursion) {
        this.id = excursion.getId();
        this.begin = excursion.getBegin();
        this.end = excursion.getEnd();
        this.price = excursion.getPrice();
        this.workerFirstName = excursion.getWorker().getFirstName();
        this.workerSecondName = excursion.getWorker().getSecondName();
    }

}
