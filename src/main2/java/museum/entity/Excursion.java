package museum.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Excursion entity.
 *
 * @author Katerena Horokh
 * @version 1.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Excursion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime begin;

  @Column(nullable = false)
  private LocalDateTime end;

  @Column(nullable = false)
  private Double price;

  @ManyToOne private Worker worker;
}
