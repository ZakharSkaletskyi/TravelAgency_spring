package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.exception.FieldNotFoundException;
import com.softserve.lv_427.travel_agency.exception.InvalidDatesException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.zip.DataFormatException;

@ControllerAdvice
@Controller
public class ExceptionController {
  @ExceptionHandler(FieldNotFoundException.class)
  public ModelAndView getExceptionPage(FieldNotFoundException e) {
    ModelAndView model = new ModelAndView();
    model.addObject("message", e.getMessage());
    model.setViewName("error");

    return model;
  }

  @ExceptionHandler(InvalidDatesException.class)
  public ModelAndView getExceptionPage(InvalidDatesException e) {
    ModelAndView model = new ModelAndView();
    model.addObject("message", e.getMessage());
    model.setViewName("error");

    return model;
  }

  @ExceptionHandler(Exception.class)
  public ModelAndView getExceptionPage(Exception e) {
    ModelAndView model = new ModelAndView();
    model.addObject(
        "message",
        "Hmm.. Something really bad happened</p>"
            + "<p>Please contact us - admin@gmail.com and send us this error:</p>"
            + e.getMessage());
    model.setViewName("error");

    return model;
  }
}
