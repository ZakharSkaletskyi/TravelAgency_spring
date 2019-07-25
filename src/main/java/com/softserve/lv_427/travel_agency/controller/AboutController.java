package com.softserve.lv_427.travel_agency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("about");
        return modelAndView;
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView allFilms() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("about");
        return modelAndView;
    }
}