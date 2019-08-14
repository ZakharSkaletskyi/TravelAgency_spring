package museum.dto.response.exhibit;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Exhibit;

@Getter
@Setter
public class ExhibitIdNameDtoResponse {
    private Long id;

    private String name;

    public ExhibitIdNameDtoResponse(Exhibit exhibit) {
        this.id = exhibit.getId();
        this.name = exhibit.getName();
    }
}
