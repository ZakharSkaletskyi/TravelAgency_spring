package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

  @PostMapping("/profile")
  public String getAllClients(
          @RequestParam  ModelMap model) {
//    model.addAttribute(
//            "ProfileClientDTO", clientService.add(((Client)new Object()));

    return "profile/profile_with_stat";
  }
  @PostMapping("/statistic")
  public String getClientStatistic(
          @RequestParam int clientId, ModelMap model) {
//    model.addAttribute(
//            "ProfileClientDTO", clientService.);

    return "profile/profile_with_stat";
  }
}
