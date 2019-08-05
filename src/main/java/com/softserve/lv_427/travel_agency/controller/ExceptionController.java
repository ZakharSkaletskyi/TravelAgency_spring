package com.softserve.lv_427.travel_agency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Controller
public class ExceptionController {
  @ExceptionHandler(Exception.class)
  public ModelAndView getException(Exception e) {
    ModelAndView model = new ModelAndView();
    model.addObject("message", e.getMessage());
    model.setViewName("error");

    return model;
  }
}