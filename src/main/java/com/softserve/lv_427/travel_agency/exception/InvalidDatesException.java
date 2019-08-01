package com.softserve.lv_427.travel_agency.exception;

public class InvalidDatesException extends RuntimeException {

    public InvalidDatesException() {
    }

    public InvalidDatesException(String message) {
        super(message);
    }

    public InvalidDatesException(final String fmt, final Object... args) {
        super(String.format(fmt, args));
    }
}