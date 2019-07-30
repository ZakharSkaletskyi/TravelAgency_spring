package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ProfileClientController {
    private final ClientServiceImpl service;

    @Autowired
    public ProfileClientController(ClientServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/profile")
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        return modelAndView;
    }
}
