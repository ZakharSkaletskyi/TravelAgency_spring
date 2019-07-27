package com.softserve.lv_427.travel_agency.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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

  @Column(name = "city_name", nullable = false, length = 30)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "country_id", nullable = false)
  private Country country;

  @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
  private List<Hotel> hotels = new ArrayList<>();
}
