package museum.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author entity.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String secondName;

  @OneToMany(mappedBy = "author")
  private List<Exhibit> exhibits = new ArrayList<Exhibit>();
}
