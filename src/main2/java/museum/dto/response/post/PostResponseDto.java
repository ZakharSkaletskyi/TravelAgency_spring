package museum.dto.response.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Post;

/**
 * DTO for Post id, name response.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class PostResponseDto {

  private Long id;

  private String name;

  /**
   * Constructor for class.
   *
   * @param post object of post.
   */
  public PostResponseDto(Post post) {
    this.id = post.getId();
    this.name = post.getName();
  }
}
