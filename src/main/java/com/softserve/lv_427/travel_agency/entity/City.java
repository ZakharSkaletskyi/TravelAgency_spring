package com.softserve.lv_427.travel_agency.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "City")
@Data
@NoArgsConstructor
public class City {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "city_name")
  private String cityName;

  @ManyToOne private Country country;
}
