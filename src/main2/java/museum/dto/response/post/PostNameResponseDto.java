package museum.dto.response.post;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Post;

/**
 * DTO for Post name response.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
public class PostNameResponseDto {

  private String name;

  /**
   * Constructor for class.
   *
   * @param post object of post.
   */
  public PostNameResponseDto(Post post) {
    this.name = post.getName();
  }
}
