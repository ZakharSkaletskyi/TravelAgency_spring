package com.softserve.lv_427.travel_agency.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Country")
@Data
@NoArgsConstructor
public class Country {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "country_name")
  private String countryName;

  @OneToMany(mappedBy = "id")
  private List<City> cities;
}
