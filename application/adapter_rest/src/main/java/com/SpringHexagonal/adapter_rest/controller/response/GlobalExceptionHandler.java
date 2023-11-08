package com.SpringHexagonal.adapter_rest.controller.response;

import com.SpringHexagonal.domain.exceptions.DniAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DniAlreadyExistsException.class)
    public ResponseEntity<Object> handleDniAlreadyExists(DniAlreadyExistsException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

}

