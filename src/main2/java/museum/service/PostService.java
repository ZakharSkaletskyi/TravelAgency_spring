package museum.service;

import museum.dto.request.post.PostRequestDto;
import museum.dto.response.post.PostResponseDto;
import museum.entity.Post;

import java.util.List;

/**
 * Service interface for Post entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
public interface PostService {

  /**
   * Save post.
   *
   * @param postRequestDto request dto
   */
  void save(PostRequestDto postRequestDto);

  /**
   * Get post by id.
   *
   * @return PostResponseDto by id.
   */
  PostResponseDto findById(Long id);

  /**
   * Get all posts.
   *
   * @return List of all post.
   */
  List<PostResponseDto> findAll();

  /**
   * Get one post by id.
   *
   * @param id post id.
   * @return Post by id.
   */
  Post getOneById(Long id);

  /**
   * Delete post by id.
   *
   * @param id post id
   */
  void delete(Long id);
}
