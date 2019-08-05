package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


// @Controller
// @RequestMapgitng()
public class ClientController {
  private final ClientService clientService;

  @Autowired
  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public ModelAndView mainPage() {
    clientService.getAllClients();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("about");
    return modelAndView;
  }
}
