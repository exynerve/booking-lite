package com.rivigo.service.exception;

public class DateFormatException extends Exception {

    final private String errorMessage;

    public DateFormatException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
