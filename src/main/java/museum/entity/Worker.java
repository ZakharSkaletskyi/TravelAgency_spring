package museum.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Pojo class for 'worker' database entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Worker {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String secondName;

  @ManyToOne private Post post;

  @OneToMany(mappedBy = "worker")
  private List<Hall> halls = new ArrayList<>();

  @OneToMany(mappedBy = "worker")
  private List<Excursion> excursions = new ArrayList<>();
}
