package com.softserve.lv_427.travel_agency.controller;
import com.softserve.lv_427.travel_agency.service.impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {
  final CountryServiceImpl service;

  @Autowired
  public AboutController(CountryServiceImpl service) {
    this.service = service;
  }


  @RequestMapping(value = "/about", method = RequestMethod.GET)
  public ModelAndView mainPage() {
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
