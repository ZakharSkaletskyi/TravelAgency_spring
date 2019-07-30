package com.softserve.lv_427.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.lv_427.travel_agency.service.impl.ClientServiceImpl;

public class ClientController {
	 final ClientServiceImpl service;

	  @Autowired
	  public ClientController(ClientServiceImpl service) {
	    this.service = service;
	  }
	  @RequestMapping(value = "/find", method = RequestMethod.GET)
	  public ModelAndView mainPage() {
	    service.getAllClients();
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("about");
	    return modelAndView;
	  }

	  
}
