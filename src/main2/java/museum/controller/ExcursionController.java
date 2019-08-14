package museum.controller;

import museum.dto.request.excursion.ExcursionSaveDtoRequest;
import museum.dto.request.excursion.ExcursionUpdateDtoRequest;
import museum.dto.response.excursion.ExcursionResponse;
import museum.dto.response.worker.WorkerFirstSecondNameDtoResponse;
import museum.service.ExcursionService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Controller for Excursion logic.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Controller
@RequestMapping("/excursion")
public class ExcursionController {

  @Autowired private ExcursionService excursionService;

  @Autowired private WorkerService workerService;

  /** Method that return all excursions. */
  @GetMapping
  public String findAll(ModelMap modelMap) {
    List<ExcursionResponse> excursions = excursionService.findAll();
    modelMap.addAttribute("excursions", excursions);
    return "excursion/excursionsInfo";
  }

  /**
   * Method for giving form for searching excursions in time period based on given input.
   *
   * @return "/excursion/excursionForm"
   */
  @RequestMapping("/byPeriodForm")
  public String showFormPage(ModelMap modelMap) {
    return "/excursion/excursionForm";
  }

  /**
   * Method for searching excursions in time period based on given input.
   *
   * @param from start of time slot to search in
   * @param to end of time slot to search in
   * @exception Exception
   */
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/byPeriod",
      params = {"start", "end"})
  public String findByPeriod(
      @RequestParam(name = "start") String from,
      @RequestParam(name = "end") String to,
      ModelMap modelMap) {
    try {
      String fromS = from.replaceAll("T", " ");
      String toS = to.replaceAll("T", " ");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
      LocalDateTime start = LocalDateTime.parse(fromS, formatter);
      LocalDateTime end = LocalDateTime.parse(toS, formatter);

      List<ExcursionResponse> excursions = excursionService.findByPeriod(start, end);
      modelMap.addAttribute("excursions", excursions);
      return "/excursion/excursions";
    } catch (Exception e) {
      return "errorMessage";
    }
  }

  /** Method that save new excursion. */
  @PostMapping("/save")
  public void save(
      @Valid @ModelAttribute ExcursionSaveDtoRequest dto, HttpServletResponse httpServletResponse) {
    excursionService.save(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/excursion");
    httpServletResponse.setStatus(302);
  }

  /** Method for jsp add page. */
  @RequestMapping("/add")
  public String addExcursionPage(ModelMap modelMap) {
    try {
      List<WorkerFirstSecondNameDtoResponse> workers = workerService.findAll();
      modelMap.addAttribute("workers", workers);
      return "excursion/addExcursion";
    } catch (Exception e) {
      return "errorMessage";
    }
  }

  /** Method that update excursion. */
  @PostMapping("/update")
  public void update(
      @Valid @ModelAttribute ExcursionUpdateDtoRequest dto,
      HttpServletResponse httpServletResponse) {
    excursionService.update(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/excursion");
    httpServletResponse.setStatus(302);
  }

  /** Method that delete excursion. */
  @PostMapping(value = "/delete", params = "id")
  public void delete(@RequestParam Long id, HttpServletResponse httpServletResponse) {
    excursionService.deleteById(id);
    httpServletResponse.setHeader("Location", "http://localhost:8080/excursion");
    httpServletResponse.setStatus(302);
  }

  /**
   * Method for statistic excursions in time period based on given input.
   *
   * @param from start of time slot to search in
   * @param to end of time slot to search in
   * @return "excursion/excursionsStatistic"
   */
  @RequestMapping(
      method = RequestMethod.GET,
      params = {"start", "end"})
  public String findCountByPeriod(
      @RequestParam(name = "start") String from,
      @RequestParam(name = "end") String to,
      ModelMap modelMap) {
    String fromS = from.replaceAll("T", " ");
    String toS = to.replaceAll("T", " ");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime start = LocalDateTime.parse(fromS, formatter);
    LocalDateTime end = LocalDateTime.parse(toS, formatter);
    int excursionsStatistic = excursionService.findCountByPeriod(start, end);
    modelMap.addAttribute("excursionsStatistic", excursionsStatistic);
    return "/excursion/excursions";
  }
}
