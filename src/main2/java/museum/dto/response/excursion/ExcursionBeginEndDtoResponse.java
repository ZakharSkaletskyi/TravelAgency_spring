package museum.dto.response.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ExcursionBeginEndDtoResponse {

    private Long id;

    private LocalDateTime begin;

    private LocalDateTime end;

    public ExcursionBeginEndDtoResponse(Excursion excursion) {
        this.id = excursion.getId();
        this.begin = excursion.getBegin();
        this.end = excursion.getEnd();
    }
}
