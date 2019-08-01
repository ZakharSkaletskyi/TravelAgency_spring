package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.exception.InvalidDatesException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Controller
public class GlobalControllerExceptionHandler {
  @ExceptionHandler(InvalidDatesException.class)
  public ModelAndView getException(InvalidDatesException e) {
    ModelAndView model = new ModelAndView();
    model.addObject("message", e.getMessage());
    model.setViewName("error");

    return model;
  }

  //  @ExceptionHandler(NoHandlerFoundException.class)
  //  public ModelAndView handle(Exception ex) {
  //    ModelAndView mv = new ModelAndView();
  //    mv.addObject("message", ex.getMessage());
  //    mv.setViewName("error");
  //
  //    return mv;
  //  }
}
