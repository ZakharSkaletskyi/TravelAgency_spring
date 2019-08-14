package com.softserve.lv_427.travel_agency.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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

  @Column(name = "hotel_name", nullable = false, length = 30)
  private String name;

  @ManyToOne
  @JoinColumn(name = "city_id", nullable = false)
  private City city;

  @OneToMany(mappedBy = "hotel")
  private List<Room> rooms = new ArrayList<>();
}
