package com.softserve.lv_427.travel_agency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {

  @GetMapping(value = "/about")
  public ModelAndView about() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("about");
    return modelAndView;
  }
}
