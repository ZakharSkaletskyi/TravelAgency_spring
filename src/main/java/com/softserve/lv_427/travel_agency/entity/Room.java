package com.softserve.lv_427.travel_agency.entity;

import lombok.*;

import javax.persistence.*;
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

  @Column(name = "room_number")
  private int roomNumber;

  @ManyToOne
  @JoinColumn(name = "hotel_id")
  private Hotel hotel;

  @OneToMany(mappedBy = "room")
  private List<RoomBook> roomBooks;

  @OneToMany(mappedBy = "room")
  private List<RoomBookArchive> roomBookArchives;
}
