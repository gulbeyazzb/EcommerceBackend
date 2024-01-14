package com.workintech.ecommerce.ecommerce.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
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