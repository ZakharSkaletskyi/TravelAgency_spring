package com.softserve.lv_427.travel_agency.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
public class Country {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "country_name")
  private String countryName;

  @ManyToOne private Visa visa;

  @OneToMany(mappedBy = "country")
  private List<City> cities;

  @ManyToMany(mappedBy = "countries")
  private List<Client> visitors;
}
