package com.softserve.lv_427.travel_agency.controller;

import com.softserve.lv_427.travel_agency.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Controller for Client logic.
 *
 * @author Oleksandr Agarkov
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/profile")
public class ProfileClientController {
  private final ClientService clientService;

  @Autowired
  public ProfileClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  /** Method that returns all clients. */
  @GetMapping
  public String getAllClient (ModelMap model) {
    model.addAttribute(
            "clients", clientService.getAllClients());

    return "profile/profiles";
  }
  /** Method that returns page with client statistic. */
  @PostMapping
  public String getClientStatistic(
          @RequestParam int clientId, ModelMap model) throws SQLException, ClassNotFoundException {
    model.addAttribute(
            "ProfileClientDTO", clientService.getProfileClientDTO(clientId));

    return "profile/profile";
  }
}
