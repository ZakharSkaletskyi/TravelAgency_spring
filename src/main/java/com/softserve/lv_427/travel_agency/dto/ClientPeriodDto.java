package com.softserve.lv_427.travel_agency.dto;

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

  public ClientPeriodDto(Client client, String dateStart, String dateEnd) {
    id = client.getId();
    firstName = client.getFirstName();
    lastName = client.getLastName();
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
  }
}
