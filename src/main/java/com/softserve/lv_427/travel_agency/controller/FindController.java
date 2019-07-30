package com.softserve.lv_427.travel_agency.controller;

import java.util.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    return modelAndView;
  }

  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public ModelAndView findPage() {
    List<Client> clients = clientService.getAllClients();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("find/find");
    modelAndView.addObject("clients", clients);
    return modelAndView;
  }
  
  
  
  

//  @RequestMapping(value = "/find", method = RequestMethod.POST)  //not used
//  public ModelAndView findPagePost(
//      @RequestParam("selectedClient") int selectedClient,
//      @RequestParam("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
//      @RequestParam("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd) {
//    System.out.println("test");
//    System.out.println(dateStart);
//    System.out.println(dateEnd.toString());
//    System.out.println("selectedClient=" + selectedClient);
//    ModelAndView modelAndView = new ModelAndView();
//    //modelAndView.setViewName("find/find_country");
//
//    
//    modelAndView.setViewName("redirect:/find_country");
//    modelAndView.addObject("selectedClient", selectedClient);
//    modelAndView.addObject("dateStart", dateStart);
//    modelAndView.addObject("dateEnd", dateEnd);
//    modelAndView.setViewName("redirect:/find_country");
//  
//
//    return modelAndView;
//  }

//  @RequestMapping(value = "/find_country", method = RequestMethod.GET)
//  public ModelAndView findCountryPage() {
//    ModelAndView modelAndView = new ModelAndView();
//    modelAndView.setViewName("find/find_country");
//    return modelAndView;
//  }

//  @RequestMapping(value = "/edit/{selectedClient}{dateStart}{dateEnd}", method = RequestMethod.GET)
//  public ModelAndView editPage(@PathVariable("selectedClient") int id,@PathVariable("dateStart")  LocalDate dateStart,@PathVariable("dateEnd") LocalDate dateEnd) {
//     System.out.println(dateStart
//     ModelAndView modelAndView = new ModelAndView();
//     modelAndView.setViewName("find/find_country");
//      //modelAndView.addObject("film", film);
//      return modelAndView;
//  }
}

//        { ////////////////////////// test
//          try {
//        	  System.out.println(visaService.CountVisaForCountry(4));
//        	  System.out.println(visaService.CountVisaForCountry(3));
//        	  System.out.println(visaService.CountVisaForCountry(2));

//            System.out.println(visaService.getId("J Q"));
//            System.out.println(visaService.getId("British tourist2"));
//
//            System.out.println(visaService.getVisasCountForTheClient(11));
//            System.out.println(visaService.getVisasCountForTheClient(12));
//            System.out.println(visaService.getVisasCountForTheClient(1));
//
//            System.out.println(visaService.getVisasForTheClient(11));
//            visaService.getVisasForTheClient(11).forEach(s->System.out.print(s.getVisaName()+"
//     |"));
//            System.out.println();
//            System.out.println(visaService.getVisasForTheClient(12));
//            visaService.getVisasForTheClient(12).forEach(s->System.out.print(s.getVisaName()+"
//     |"));
//            System.out.println();
//            System.out.println(visaService.getVisasForTheClient(1));
//
//          } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//          }
//        }
