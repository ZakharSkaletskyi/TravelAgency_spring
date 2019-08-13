package com.softserve.lv_427.travel_agency.service.external;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class DaysService {
  public int getDaysFromPeriod(String dateStart, String dateEnd) {
    int[] firstDay = get3Int(dateStart);
    int[] lastDay = get3Int(dateEnd);
    LocalDate start = LocalDate.of(firstDay[0], firstDay[1], firstDay[2]);
    LocalDate end = LocalDate.of(lastDay[0], lastDay[1], lastDay[2]);
    return (int) ChronoUnit.DAYS.between(start, end);
  }

  private int[] get3Int(String s) {
    String[] s1 = s.split("-");
    int[] n = new int[3];
    for (int i = 0; i < 3; i++) {
      n[i] = Integer.parseInt(s1[i]);
    }
    return n;
  }
}
