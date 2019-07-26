package com.softserve.lv_427.travel_agency.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "room_book")
@Getter
@Setter
@NoArgsConstructor
public class RoomBook {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "order_start", nullable = false)
  @Type(type = "date")
  private Date orderStart;

  @Column(name = "order_end", nullable = false)
  @Type(type = "date")
  private Date orderEnd;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "room_id", nullable = false)
  private Room room;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id", nullable = false)
  private Client client;
}
