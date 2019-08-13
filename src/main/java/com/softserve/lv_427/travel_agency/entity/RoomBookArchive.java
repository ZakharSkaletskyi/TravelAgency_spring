package com.softserve.lv_427.travel_agency.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "room_book_archive")
@Getter
@Setter
@NoArgsConstructor
public class RoomBookArchive {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "order_start", nullable = false)
  private String orderStart;

  @Column(name = "order_end", nullable = false)
  private String orderEnd;

  @ManyToOne
  @JoinColumn(name = "room_id", nullable = false)
  private Room room;

  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false)
  private Client client;
}
