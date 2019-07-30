package com.softserve.lv_427.travel_agency.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
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

  @Column(name = "last_name", nullable = false, length = 30)
  private String lastName;

  @Column(name = "first_name", nullable = false, length = 30)
  private String firstName;

  @Column(name = "phone_number", nullable = false, length = 15)
  private String phoneNumber;

  @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
  private List<RoomBook> roomBooks = new ArrayList<>();

  @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
  private List<RoomBookArchive> roomBookArchives = new ArrayList<>();

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
      name = "client_visa",
      joinColumns = {@JoinColumn(name = "client_id", nullable = false, updatable = false)},
      inverseJoinColumns = {@JoinColumn(name = "visa_id", nullable = false, updatable = false)})
  private List<Visa> visas = new ArrayList<>();

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
      name = "client_country",
      joinColumns = {@JoinColumn(name = "client_id", nullable = false, updatable = false)},
      inverseJoinColumns = {@JoinColumn(name = "country_id", nullable = false, updatable = false)})
  private List<Country> countries = new ArrayList<>();
}
