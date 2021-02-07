package com.rivigo.service.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class VehicleNotAvailableException extends Exception {
    final private String errorMessage;

    public VehicleNotAvailableException(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
