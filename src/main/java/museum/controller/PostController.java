package museum.controller;

import museum.dto.request.post.PostRequestDto;
import museum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Controller class for 'post' page.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Controller
@RequestMapping("/post")
public class PostController {

  @Autowired private PostService postService;

  /**
   * Handles request to post post into db.
   *
   * @param postRequestDto post request dto from jsp.
   * @param httpServletResponse http response.
   */
  @PostMapping
  public void save(
      @Valid @ModelAttribute PostRequestDto postRequestDto,
      HttpServletResponse httpServletResponse) {
    postService.save(postRequestDto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/worker");
    httpServletResponse.setStatus(302);
  }

  /** Handles request to redirect on addPost page. */
  @RequestMapping("/add")
  public String addPostPage() {
    return "worker/addPost";
  }

  /**
   * Handles request to post worker into db.
   *
   * @param id post id.
   * @param httpServletResponse http response.
   */
  @GetMapping(value = "/delete", params = "id")
  public void deleteWorker(@RequestParam Long id, HttpServletResponse httpServletResponse) {
    postService.delete(id);
    httpServletResponse.setHeader("Location", "http://localhost:8080/worker");
    httpServletResponse.setStatus(302);
  }
}
