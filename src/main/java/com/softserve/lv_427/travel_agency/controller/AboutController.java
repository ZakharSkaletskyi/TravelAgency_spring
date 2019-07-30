package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.CountryService;
import com.softserve.lv_427.travel_agency.service.impl.CountryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/about")
public class AboutController {
	@Autowired private CountryServiceImpl service;

  @GetMapping
  public ModelAndView about() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("about");
    return modelAndView;
  }

  //  @RequestMapping(value = "/about", method = RequestMethod.GET)
  //  public ModelAndView allFilms() {
  //    ModelAndView modelAndView = new ModelAndView();
  //    modelAndView.setViewName("about");
  //    return modelAndView;
  //  }
}
