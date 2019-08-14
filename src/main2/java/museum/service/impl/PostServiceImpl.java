package museum.service.impl;

import museum.dao.PostDao;
import museum.dto.request.post.PostRequestDto;
import museum.dto.response.post.PostDto;
import museum.dto.response.post.PostNameResponseDto;
import museum.dto.response.post.PostResponseDto;
import museum.entity.Post;
import museum.exception.BadIdException;
import museum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for Post entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Service
public class PostServiceImpl implements PostService {

  @Autowired private PostDao postDao;

  /**
   * Save post.
   *
   * @param postRequestDto request dto
   */
  @Transactional
  @Override
  public void save(PostRequestDto postRequestDto) {
    Post post = postRequestDtoToPost(postRequestDto);
    postDao.save(post);
  }

  /**
   * Get post by id.
   *
   * @return PostResponseDto by id.
   */
  @Transactional
  @Override
  public PostResponseDto findById(Long id) {
    Post post = postDao.findById(id);
    return postToPostResponseDto(post);
  }

  /**
   * Get all posts.
   *
   * @return List of all post.
   */
  @Transactional
  @Override
  public List<PostResponseDto> findAll() {
    return postDao.findAll().stream().map(PostResponseDto::new).collect(Collectors.toList());
  }

  /**
   * Get one post by id.
   *
   * @param id post id.
   * @return Post by id.
   */
  @Transactional
  @Override
  public Post getOneById(Long id) {
    Post post = postDao.findById(id);
    if (post == null) {
      throw new BadIdException("Post with id " + id + " doesn't exist");
    }
    return post;
  }

  /**
   * Delete post by id.
   *
   * @param id post id
   */
  @Transactional
  @Override
  public void delete(Long id) {
    Boolean isDeleted = postDao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Post with entered id doesn't exist");
    }
  }

  /**
   * Mapper from PostRequestDto to Post.
   *
   * @param postRequestDto request dto.
   * @return Post.
   */
  private Post postRequestDtoToPost(PostRequestDto postRequestDto) {
    Post post = new Post();
    post.setName(postRequestDto.getName());
    return post;
  }

  /**
   * Mapper from Post to PostResponseDto.
   *
   * @param post post object.
   * @return PostResponseDto.
   */
  private PostResponseDto postToPostResponseDto(Post post) {
    PostResponseDto postResponseDto = new PostResponseDto();
    postResponseDto.setId(post.getId());
    postResponseDto.setName(post.getName());
    return new PostResponseDto();
  }
}
