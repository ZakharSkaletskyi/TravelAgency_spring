package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class AboutController {
  private final AboutService aboutService;

  @Autowired
  public AboutController(AboutService aboutService) {
    this.aboutService = aboutService;
  }

  @GetMapping(value = "/about")
  public String about(ModelMap modelMap) throws SQLException {
    modelMap.addAttribute("aboutDto", aboutService.getAboutDto());

    return "about";
  }
}
