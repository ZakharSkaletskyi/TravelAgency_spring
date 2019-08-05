package com.softserve.lv_427.travel_agency.service.external;

import com.softserve.lv_427.travel_agency.exception.InvalidDatesException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
  public void validateDateForAvailability(String startDate, String endDate) {
    if (isStartDateBiggerThanEndDate(startDate, endDate)) {
      throw new InvalidDatesException(
          "Дата виїзду (" + endDate + ") має бути більшою за дату заїзду (" + startDate + ") !");
    }
  }

  public void validateDateForStatistic(String startDate, String endDate) {
    if (isStartDateBiggerThanEndDate(startDate, endDate)) {
      throw new InvalidDatesException(
          "Кінцева дата ("
              + endDate
              + ") статистики має бути меншою за початкову ("
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
