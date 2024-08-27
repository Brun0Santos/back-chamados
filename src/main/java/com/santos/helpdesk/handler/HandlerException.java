package com.santos.helpdesk.handler;

import com.santos.helpdesk.exceptions.ExistingDataException;
import com.santos.helpdesk.exceptions.NotFoundException;
import com.santos.helpdesk.exceptions.ResponseGlobalException;
import com.santos.helpdesk.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ResponseGlobalException> notFoundException(NotFoundException ex, WebRequest request) {
        ResponseGlobalException responseGlobalException = new ResponseGlobalException(new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(responseGlobalException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExistingDataException.class)
    public final ResponseEntity<ResponseGlobalException> existingData(ExistingDataException ex, WebRequest request) {
        ResponseGlobalException responseGlobalException = new ResponseGlobalException(new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(responseGlobalException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ValidationException> validationFields(MethodArgumentNotValidException ex, WebRequest request) {
        ValidationException validationException = new ValidationException(new Date(),
                ex.getMessage(),
                request.getDescription(false));

        for (FieldError error : ex.getFieldErrors()) {
            validationException.addError(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(validationException, HttpStatus.BAD_REQUEST);
    }
}
