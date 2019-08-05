package com.softserve.lv_427.travel_agency.exception;

public class BaseException extends RuntimeException {

  public BaseException() {}

  public BaseException(String message) {
    super(message);
  }

  public BaseException(final String fmt, final Object... args) {
    super(String.format(fmt, args));
  }
}
