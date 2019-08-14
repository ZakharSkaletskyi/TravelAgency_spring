package museum.controller;

import museum.dto.request.exhibit.ExhibitSaveDtoRequest;
import museum.dto.request.exhibit.ExhibitUpdateDtoRequest;
import museum.dto.response.exhibit.ExhibitDtoResponse;
import museum.dto.response.exhibit.ExhibitIdNameDtoResponse;
import museum.dto.response.exhibit.ExhibitMaterialStat;
import museum.dto.response.exhibit.ExhibitTechnologyStat;
import museum.service.AuthorService;
import museum.service.ExhibitService;
import museum.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Controller for Exhibit logic.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Controller
@RequestMapping("/exhibit")
public class ExhibitController {

  @Autowired private ExhibitService service;
  @Autowired private AuthorService authorService;
  @Autowired private HallService hallService;

  /** Method that return all exhibit. */
  @GetMapping
  public String findAll(ModelMap modelMap) {
    List<ExhibitIdNameDtoResponse> authors = service.findAll();
    modelMap.addAttribute("exhibits", authors);
    return "exhibit/exhibits";
  }

  /** Method that return exhibit by id. */
  @GetMapping(params = "id")
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    ExhibitDtoResponse exhibit = service.findById(id);
    modelMap.addAttribute("exhibit", exhibit);
    return "exhibit/exhibitInfo";
  }

  /** Method that save new exhibit. */
  @PostMapping("/save")
  public void save(
      @Valid @ModelAttribute ExhibitSaveDtoRequest dto, HttpServletResponse httpServletResponse) {
    service.save(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/exhibit");
    httpServletResponse.setStatus(302);
  }

  /** Method that update exhibit. */
  @PostMapping("/update")
  public void update(
      @Valid @ModelAttribute ExhibitUpdateDtoRequest dto, HttpServletResponse httpServletResponse) {
    service.update(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/exhibit");
    httpServletResponse.setStatus(302);
  }

  /** Method that delete exhibit by id. */
  @GetMapping("/delete")
  public void delete(@RequestParam Long id, HttpServletResponse httpServletResponse) {
    service.deleteById(id);
    httpServletResponse.setHeader("Location", "http://localhost:8080/exhibit");
    httpServletResponse.setStatus(302);
  }

  /** Method for jsp add page. */
  @RequestMapping("/add")
  public String addExhibitPage(ModelMap modelMap) {
    modelMap.addAttribute("authors", authorService.findAll());
    modelMap.addAttribute("halls", hallService.findAll());
    return "exhibit/addExhibit";
  }
  /** Method for jsp edit page. */
  @RequestMapping(value = "/edit", params = "id")
  public String updateExhibitPage(@RequestParam Long id, ModelMap modelMap) {
    ExhibitDtoResponse exhibit = service.findById(id);
    modelMap.addAttribute("exhibit", exhibit);
    modelMap.addAttribute("authors", authorService.findAll());
    modelMap.addAttribute("halls", hallService.findAll());
    return "exhibit/editExhibit";
  }

  /** Method for jsp statistic page. */
  @RequestMapping("/stat")
  public String getStatistic(ModelMap modelMap) {
    List<ExhibitMaterialStat> exhibitMaterialStats = service.getMaterialStat();
    modelMap.addAttribute("exhibitMaterialStats", exhibitMaterialStats);
    List<ExhibitTechnologyStat> exhibitTechnologyStats = service.getTechnologyStat();
    modelMap.addAttribute("exhibitTechnologyStats", exhibitTechnologyStats);
    return "exhibit/exhibitStat";
  }
}
