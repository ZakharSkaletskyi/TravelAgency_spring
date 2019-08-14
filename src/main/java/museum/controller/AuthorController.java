package museum.controller;

import museum.dto.request.author.AuthorSaveDtoRequest;
import museum.dto.request.author.AuthorUpdateDtoRequest;
import museum.dto.response.author.AuthorDtoResponse;
import museum.dto.response.author.AuthorIdFirstSecondNameDtoResponse;
import museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Controller for Author logic.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Controller
@RequestMapping("/author")
public class AuthorController {

  @Autowired private AuthorService service;

  /** Method that return all authors. */
  @GetMapping
  public String findAll(ModelMap modelMap) {
    List<AuthorIdFirstSecondNameDtoResponse> authors = service.findAll();
    modelMap.addAttribute("authors", authors);
    return "author/authors";
  }

  /** Method that return author by id. */
  @GetMapping(params = "id")
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    AuthorDtoResponse author = service.findById(id);
    modelMap.addAttribute("author", author);
    return "author/authorInfo";
  }

  /** Method that save new author. */
  @PostMapping("/save")
  public void save(
      @Valid @ModelAttribute AuthorSaveDtoRequest dto, HttpServletResponse httpServletResponse) {
    service.save(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/author");
    httpServletResponse.setStatus(302);
  }

  /** Method that update author. */
  @PostMapping("/update")
  public void update(
      @Valid @ModelAttribute AuthorUpdateDtoRequest dto, HttpServletResponse httpServletResponse) {
    service.update(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/author");
    httpServletResponse.setStatus(302);
  }

  /** Method that delete author by id. */
  @GetMapping(value = "/delete", params = "id")
  public void delete(@RequestParam Long id, HttpServletResponse httpServletResponse) {
    service.deleteById(id);
    httpServletResponse.setHeader("Location", "http://localhost:8080/author");
    httpServletResponse.setStatus(302);
  }

  /** Method for jsp add page. */
  @RequestMapping("/add")
  public String addAuthorPage() {
    return "author/addAuthor";
  }

  /** Method for jsp edit page. */
  @RequestMapping(value = "/edit", params = "id")
  public String updateAuthorPage(@RequestParam Long id, ModelMap modelMap) {
    AuthorDtoResponse author = service.findById(id);
    modelMap.addAttribute("author", author);
    return "author/editAuthor";
  }
}
