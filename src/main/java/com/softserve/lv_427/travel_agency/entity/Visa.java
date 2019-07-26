package com.softserve.lv_427.travel_agency.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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

  @Column(name = "visa_name", nullable = false, length = 30)
  private String visaName;

  @OneToMany(mappedBy = "visa", fetch = FetchType.LAZY)
  private List<Country> countries = new ArrayList<>();

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "visas")
  private List<Client> clients = new ArrayList<>();
}
