package com.softserve.lv_427.travel_agency.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "phone_number")
  private int phoneNumber;

  @OneToMany(mappedBy = "client")
  private List<RoomBook> roomBooks;

  @OneToMany(mappedBy = "client")
  private List<RoomBookArchive> roomBookArchives;

  @ManyToMany
  @JoinTable(
      name = "client_visa",
      joinColumns = {@JoinColumn(name = "client_id")},
      inverseJoinColumns = {@JoinColumn(name = "visa_id")})
  private List<Visa> visas;

  @ManyToMany
  @JoinTable(
      name = "client_country",
      joinColumns = {@JoinColumn(name = "client_id")},
      inverseJoinColumns = {@JoinColumn(name = "country_id")})
  private List<Country> countries;
}
