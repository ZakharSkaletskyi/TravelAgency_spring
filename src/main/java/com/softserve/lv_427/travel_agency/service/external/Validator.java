package com.softserve.lv_427.travel_agency.service.external;

import com.softserve.lv_427.travel_agency.exception.InvalidDatesException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
  public void validateDateForAvailability(String startDate, String endDate) {
    if (isStartDateBiggerThanEndDate(startDate, endDate)) {
      throw new InvalidDatesException(
          "Check out date (" + endDate + ") must be greater than the check-in date (" + startDate + ") !");
    }
  }

  public void validateDateForStatistic(String startDate, String endDate) {
    if (isStartDateBiggerThanEndDate(startDate, endDate)) {
      throw new InvalidDatesException(
          "End date ("
              + endDate
              + ")of statistics should be less than start date ("
              + startDate
              + ") !");
    }
  }

  public boolean isStartDateBiggerThanEndDate(String startDate, String endDate)
      throws InvalidDatesException {
    Date startDateD = null;
    Date endDateD = null;

    try {
      startDateD = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
      endDateD = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return startDateD.after(endDateD);
  }
}
