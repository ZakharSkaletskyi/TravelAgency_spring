package com.softserve.lv_427.travel_agency.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
public class Hotel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "hotel_name")
  private String cityName;

  @ManyToOne
  @JoinColumn(name = "city_id")
  private City city;

  @OneToMany(mappedBy = "hotel")
  private List<Room> rooms;
}
