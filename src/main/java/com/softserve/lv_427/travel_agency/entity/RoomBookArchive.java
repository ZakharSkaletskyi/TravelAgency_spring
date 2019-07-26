package com.softserve.lv_427.travel_agency.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "room_book_archive")
@Getter
@Setter
@NoArgsConstructor
public class RoomBookArchive {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "order_start")
  private Date orderStart;

  @Column(name = "order_end")
  private Date orderEnd;

  @ManyToOne
  @JoinColumn(name = "room_id")
  private Room room;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;
}
