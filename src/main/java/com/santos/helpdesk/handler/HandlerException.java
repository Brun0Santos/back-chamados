package com.santos.helpdesk.handler;

import com.santos.helpdesk.exceptions.NotFoundException;
import com.santos.helpdesk.exceptions.ResponseGlobalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ResponseGlobalException> notFoundException(Exception ex, WebRequest request) {
        ResponseGlobalException responseGlobalException = new ResponseGlobalException(new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(responseGlobalException, HttpStatus.NOT_FOUND);
    }
}
