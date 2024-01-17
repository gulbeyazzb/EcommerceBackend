package com.workintech.ecommerce.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException{

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(CommerceException commerceException) {
        ErrorResponse errorResponse = new ErrorResponse(
                commerceException.getHttpStatus().value(), commerceException.getMessage(), LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, commerceException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}