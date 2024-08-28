package com.santos.helpdesk.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FieldMessageException {
    private String fieldName;

    private String message;
}
