package museum.controller;

import museum.dto.request.hall.HallSaveRequest;
import museum.dto.request.hall.HallUpdateRequest;
import museum.dto.response.hall.HallDtoResponse;
import museum.dto.response.hall.HallIdNameDtoResponse;
import museum.dto.response.worker.WorkerFirstSecondNameDtoResponse;
import museum.service.HallService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Controller for Hall logic.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Controller
@RequestMapping("/hall")
public class HallController {

  @Autowired private HallService service;

  @Autowired private WorkerService workerService;

  /** Method that return all halls. */
  @GetMapping
  public String findAll(ModelMap modelMap) {
    List<HallIdNameDtoResponse> halls = service.findAll();
    modelMap.addAttribute("halls", halls);
    return "hall/halls";
  }

  @GetMapping(params = "id")
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    HallDtoResponse hall = service.findById(id);
    modelMap.addAttribute("hall", hall);
    return "hall/hallInfo";
  }

  /** Method that save new hall. */
  @PostMapping("/save")
  public void save(
      @Valid @ModelAttribute HallSaveRequest dto, HttpServletResponse httpServletResponse) {
    service.save(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/hall");
    httpServletResponse.setStatus(302);
  }

  /** Method that update hall. */
  @PostMapping("/update")
  public void update(
      @Valid @ModelAttribute HallUpdateRequest dto, HttpServletResponse httpServletResponse) {
    service.update(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/hall");
    httpServletResponse.setStatus(302);
  }

  /** Method that delete hall. */
  @GetMapping(value = "/delete", params = "id")
  public void delete(@RequestParam Long id, HttpServletResponse httpServletResponse) {
    service.deleteById(id);
    httpServletResponse.setHeader("Location", "http://localhost:8080/hall");
    httpServletResponse.setStatus(302);
  }

  /** Method for jsp add page. */
  @RequestMapping("/add")
  public String addAuthorPage(ModelMap modelMap) {
    List<WorkerFirstSecondNameDtoResponse> workers = workerService.findAll();
    modelMap.addAttribute("workers", workers);
    return "hall/addHall";
  }

  /** Method that update author page. */
  @RequestMapping(value = "/edit", params = "id")
  public String updateAuthorPage(@RequestParam Long id, ModelMap modelMap) {
    HallDtoResponse hall = service.findById(id);
    modelMap.addAttribute("hall", hall);
    List<WorkerFirstSecondNameDtoResponse> workers = workerService.findAll();
    modelMap.addAttribute("workers", workers);
    return "hall/editHall";
  }
}
