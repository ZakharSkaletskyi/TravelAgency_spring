package com.softserve.lv_427.travel_agency.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.softserve.lv_427.travel_agency.entity.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientPeriodDto {
	
  private int id;
  private String firstName;
  private String lastName;
private String dateStart;
private String dateEnd;
//  private @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart;
//  private @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd;
//
  public ClientPeriodDto(
	      Client client,
	   String dateStart,
	      String dateEnd) {
	    id = client.getId();
	    firstName = client.getFirstName();
	    lastName = client.getLastName();
	    this.dateStart = dateStart;
	    this.dateEnd = dateEnd;
	  }
//  public ClientPeriodDto(
//      Client client,
//      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
//      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd) {
//    id = client.getId();
//    firstName = client.getFirstName();
//    lastName = client.getLastName();
//    this.dateStart = dateStart;
//    this.dateEnd = dateEnd;
//  }
//  public ClientPeriodDto(
//	      int clientId,
//	      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
//	      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd) {
//	    id = clientId;
//	    firstName = client.getFirstName();
//	    lastName = client.getLastName();
//	    this.dateStart = ClientServiceImpl;
//	    this.dateEnd = dateEnd;
//	  }
  
}
