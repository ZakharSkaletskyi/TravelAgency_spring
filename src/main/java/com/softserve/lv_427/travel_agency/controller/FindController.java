package com.softserve.lv_427.travel_agency.controller;

import java.util.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.service.ClientService;
import com.softserve.lv_427.travel_agency.service.VisaService;

@Controller
public class FindController {
  @Autowired private ClientService clientService;
  @Autowired private VisaService visaService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView mainPage() {
    //    List<Client> clients = clientService.getAllClients(); // ///test
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    //    modelAndView.addObject("clients", clients); // ///test
    return modelAndView;
  }

  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public ModelAndView findPage() {
    List<Client> clients = clientService.getAllClients();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("find/find");
    modelAndView.addObject("clients", clients);
    // modelAndView.addObject("date", date.getLocalDate().getClass());
    return modelAndView;
  }

  @RequestMapping(value = "/find", method = RequestMethod.POST)
  public ModelAndView findPagePost(
      @RequestParam("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
      @RequestParam("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd) {
    System.out.println("test");
    System.out.println(dateStart);
    System.out.println(dateEnd.toString());
   
    
    {//////////////////////////test
    	
    		
    	
    	try {
    		
        	
   System.out.println(visaService.getId("J Q"));
   System.out.println(visaService.getId("British tourist"));
   
   System.out.println(visaService.getVisasCountForTheClient(clientId));
      
    } catch (ClassNotFoundException | SQLException e) {
      // TODO Auto-generated catch block
    e.printStackTrace();
    } 
    	
    	
    }
    
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("redirect:/find_country");
    return modelAndView;
  }
}
