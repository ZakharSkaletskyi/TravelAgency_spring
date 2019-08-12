package com.softserve.lv_427.travel_agency.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AboutDto {
  int countOfClient;
  List<List<String>> visas;
}
