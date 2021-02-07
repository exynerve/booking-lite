package com.rivigo.service.exception;

public class CityNotFoundException extends Exception {

    final private String errorMessage;

    public CityNotFoundException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
