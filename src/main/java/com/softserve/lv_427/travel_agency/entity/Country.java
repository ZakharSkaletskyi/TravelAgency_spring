package com.softserve.lv_427.travel_agency.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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

  @Column(name = "country_name", unique = true, nullable = false, length = 30)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  private Visa visa;

  @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
  private List<City> cities = new ArrayList<>();

  @ManyToMany(mappedBy = "countries", fetch = FetchType.LAZY)
  private List<Client> visitors = new ArrayList<>();
}
