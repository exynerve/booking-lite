package com.rivigo.service.exception;

public class InvalidDateException extends Exception {

    final private String errorMessage;

    public InvalidDateException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
