package com.santos.helpdesk.exceptions;

public class ExistingDataException extends RuntimeException {

    public ExistingDataException(String message) {
        super(message);
    }
}
