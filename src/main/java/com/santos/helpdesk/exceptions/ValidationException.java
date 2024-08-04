package com.santos.helpdesk.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ValidationException {
    private Date timestamp;

    private String message;

    private String detail;

    private List<FieldMessageException> fieldsError = new ArrayList<>();

    public ValidationException(Date timestamp, String message, String detail) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }

    public void addError(String field, String message) {
        fieldsError.add(new FieldMessageException(field, message));
    }
}
