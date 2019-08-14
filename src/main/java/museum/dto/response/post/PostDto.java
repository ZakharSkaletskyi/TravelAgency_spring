package museum.dto.response.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Post;
import museum.entity.Worker;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * DTO for Post id, name, workers response
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class PostDto {

  @NotNull private Long id;

  @NotBlank private String name;

  private List<Worker> workers;

  /**
   * Constructor for class.
   *
   * @param post object of post.
   */
  public PostDto(Post post) {
    this.id = post.getId();
    this.name = post.getName();
  }
}
