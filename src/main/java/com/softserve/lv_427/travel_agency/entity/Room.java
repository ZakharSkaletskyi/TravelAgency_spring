package com.softserve.lv_427.travel_agency.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "room_number", nullable = false)
  private int number;

  @ManyToOne
  @JoinColumn(name = "hotel_id", nullable = false)
  private Hotel hotel;

  @OneToMany(mappedBy = "room")
  private List<RoomBook> roomBooks = new ArrayList<>();

  @OneToMany(mappedBy = "room")
  private List<RoomBookArchive> roomBookArchives = new ArrayList<>();
}
