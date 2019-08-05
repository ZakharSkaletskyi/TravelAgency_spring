package com.softserve.lv_427.travel_agency.controller;

import java.util.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.lv_427.travel_agency.dto.ClientPeriodDto;
import com.softserve.lv_427.travel_agency.entity.City;
import com.softserve.lv_427.travel_agency.entity.Client;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.entity.Hotel;
import com.softserve.lv_427.travel_agency.service.CityService;
import com.softserve.lv_427.travel_agency.service.ClientService;
import com.softserve.lv_427.travel_agency.service.HotelService;
import com.softserve.lv_427.travel_agency.service.VisaService;

@Controller
public class FindController {
  @Autowired private ClientService clientService;
  @Autowired private VisaService visaService;
  @Autowired private CityService cityService;
  @Autowired private HotelService hotelService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView mainPage() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    return modelAndView;
  }
  // @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)

  // <form:form method="POST" action="/spring-mvc-basics/addEmployee" modelAttribute="employee">
  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public String findPage(ModelMap model) {
    List<Client> clients = clientService.getAllClients();

    model.addAttribute("clients", clients);
    return "find/find";
  }

  @RequestMapping(value = "/find_country", method = RequestMethod.POST)
  public String findCountryPage(
      ModelMap model, @ModelAttribute("ClientPeriodDto") ClientPeriodDto clientPeriodDto)
      throws ClassNotFoundException {

    System.out.println("from" + clientPeriodDto.getDateStart());
    System.out.println("to" + clientPeriodDto.getDateEnd());
    System.out.println("selectedClient=" + clientPeriodDto.getId());

    model.addAttribute(
        "ClientPeriodDto",
        clientService.getClientPeriodDto(
            clientPeriodDto.getId(), clientPeriodDto.getDateStart(), clientPeriodDto.getDateEnd()));
    System.out.println(
        "test-  find countries- after adding ClientPeriodDto-"
            + ((ClientPeriodDto) model.get("ClientPeriodDto")).getFirstName());
    List<Country> countries = clientService.getAvailableCountries(clientPeriodDto.getId());
    countries.forEach(s -> System.out.print(s.getName() + " | ")); // print
    System.out.println();
    model.addAttribute("countries", countries);

    return "find/find_country";
  }

  //  @RequestMapping(value = "/find_country", method = RequestMethod.GET)
  //  public String toCityPage(ModelMap model,
  //		  @RequestParam("selectedCountry") int selectedCountryId
  //		  , @ModelAttribute("ClientPeriodDto") ClientPeriodDto clientPeriodDto)
  //      throws ClassNotFoundException {
  //
  //	  ClientPeriodDto clientPeriodDTO = (ClientPeriodDto) model.get("ClientPeriodDto");
  //		 // System.out.println(model.get("countries").toString());
  //		  System.out.println("/find_country toCityPage"+clientPeriodDTO);
  //		  System.out.println("/find_country - toCityPage -
  // ClientPeriodDto.name"+clientPeriodDTO.getFirstName());
  //	    List<City> cities =
  //	        cityService.getCitiesWithAvailableHotels(
  //	            selectedCountryId, clientPeriodDTO.getDateStart(), clientPeriodDTO.getDateEnd());
  //	    cities.forEach(s -> System.out.print(s.getName() + " | ")); // print
  //	    System.out.println();
  //	    model.addAttribute("cities", cities);
  //	    return "find/city";
  //  }

  //  @RequestMapping(value = "/find_country", method = RequestMethod.POST)
  //  public String findCountryPage(ModelMap model,
  //      @RequestParam("selectedClient") int selectedClientId,
  //      @RequestParam("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
  //      @RequestParam("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd)
  //      throws ClassNotFoundException {
  //
  //    System.out.println("from" + dateStart);
  //    System.out.println("to" + dateEnd.toString());
  //    System.out.println("selectedClient=" + selectedClientId);
  //
  //    model.addAttribute("clientWithPeriod", clientService.getClientPeriodDto(selectedClientId,
  // dateStart, dateEnd));
  //    System.out.println("test-  find countries- after adding clientWithPeriod"+((ClientPeriodDto)
  // model.get("clientWithPeriod")).getFirstName());
  //    List<Country> countries = clientService.getAvailableCountries(selectedClientId);
  //    countries.forEach(s -> System.out.print(s.getName() + " | ")); // print
  //    System.out.println();
  //    model.addAttribute("countries", countries);
  //
  //    return "find/find_country";
  //  }
  @RequestMapping(value = "find_city", method = RequestMethod.POST)
  public String findCityPage(
      ModelMap model,
      @RequestParam("selectedCountry") int selectedCountryId,
      @ModelAttribute("ClientPeriodDto") ClientPeriodDto clientPeriodDto
      //      ,@RequestParam("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate
      // dateStart,
      //      @RequestParam("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd
      ) throws ClassNotFoundException {
    //    System.out.println("from" + dateStart);
    //    System.out.println("to" + dateEnd.toString());
    //    System.out.println("selectedCountry=" + selectedCountryId);

    ClientPeriodDto clientPeriodDTO = (ClientPeriodDto) model.get("ClientPeriodDto");
    // System.out.println(model.get("countries").toString());
    System.out.println("/find_city ClientPeriodDto=" + clientPeriodDTO);
    System.out.println("/find_city - from - ClientPeriodDto.name=" + clientPeriodDTO.getFirstName());
    List<City> cities =
        cityService.getCitiesWithAvailableHotels(
            selectedCountryId, clientPeriodDTO.getDateStart(), clientPeriodDTO.getDateEnd());
    cities.forEach(s -> System.out.print(s.getName() + " | ")); // print
    System.out.println();
    model.addAttribute("cities", cities);
    return "find/find_city";
  }
  @RequestMapping(value = "find_hotels", method = RequestMethod.POST)
  public String findHotelsPage(
      ModelMap model,
      @RequestParam("selectedCity") int selectedCityId,
      @ModelAttribute("ClientPeriodDto") ClientPeriodDto clientPeriodDto
      //      ,@RequestParam("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate
      // dateStart,
      //      @RequestParam("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd
      ) throws ClassNotFoundException {
    //    System.out.println("from" + dateStart);
    //    System.out.println("to" + dateEnd.toString());
    //    System.out.println("selectedCountry=" + selectedCountryId);

   
    // System.out.println(model.get("countries").toString());
    System.out.println("/find_city ClientPeriodDto=" + clientPeriodDto);
    System.out.println("/find_city - from - ClientPeriodDto.name=" + clientPeriodDto.getFirstName());
    List<Hotel> hotels =
    		hotelService.getAvailableHotelsOnDatesInCity(selectedCityId, clientPeriodDto.getDateStart(), clientPeriodDto.getDateEnd());
    hotels.forEach(s -> System.out.print(s.getName() + " | ")); // print
    System.out.println();
    model.addAttribute("hotels", hotels);
    return "find/find_hotels";
  }
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

  //  @RequestMapping(value = "/edit/{selectedClient}{dateStart}{dateEnd}", method =
  // RequestMethod.GET)
  //  public ModelAndView editPage(@PathVariable("selectedClient") int id,@PathVariable("dateStart")
  //  LocalDate dateStart,@PathVariable("dateEnd") LocalDate dateEnd) {
  //     System.out.println(dateStart
  //     ModelAndView modelAndView = new ModelAndView();
  //     modelAndView.setViewName("find/find_country");
  //      //modelAndView.addObject("film", film);
  //      return modelAndView;
  //  }


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
