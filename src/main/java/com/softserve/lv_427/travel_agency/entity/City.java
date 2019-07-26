package com.softserve.lv_427.travel_agency.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
public class City {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "city_name")
  private String cityName;

  @ManyToOne
  @JoinColumn(name = "country_id")
  private Country country;

  @OneToMany(mappedBy = "city")
  private List<Hotel> hotels;
}
