package com.softserve.lv_427.travel_agency.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "visa")
@Getter
@Setter
@NoArgsConstructor
public class Visa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "visa_name")
  private String visaName;

  @OneToMany(mappedBy = "visa")
  private List<Country> countries;

  @ManyToMany(mappedBy = "visas")
  private List<Client> clients;
}
