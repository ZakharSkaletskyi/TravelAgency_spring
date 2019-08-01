package com.softserve.lv_427.travel_agency;

import com.softserve.lv_427.travel_agency.exception.InvalidDatesException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
  public void validateDateForAvailability(String startDate, String endDate)
      throws InvalidDatesException {
    Date startDateD = null;
    Date endDateD = null;
    try {
      startDateD = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
      endDateD = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    if (startDateD.after(endDateD)) {
      throw new InvalidDatesException(
          "Друга дата (" + endDate + ") має бути більшою за першу (" + startDate + ") !");
    }
  }
}
