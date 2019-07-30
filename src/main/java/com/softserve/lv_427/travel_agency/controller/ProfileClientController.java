package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/profile")
public class ProfileClientController {
  private final ClientService clientService;

  @Autowired
  public ProfileClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping
  public ModelAndView profile() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("profile");
    return modelAndView;
  }

  //  @PostMapping
  //  public String getClientInfo(@RequestParam int clientId, ModelMap model) {
  //    model.addAttribute("clientCountries", clientService.getById(clientId));
  //
  //    return "clientCountries";
  //  }
}
