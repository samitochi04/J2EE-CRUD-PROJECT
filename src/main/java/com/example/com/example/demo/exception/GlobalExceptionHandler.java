package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handling UserAlreadyExistsException
    @ExceptionHandler(ComputerAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(ComputerAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT); // 409 Conflict
    }

    // Handling NoSuchUserExistsException
    @ExceptionHandler(NoSuchComputerExistsException.class)
    public ResponseEntity<String> handleNoSuchUserExistsException(NoSuchComputerExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND); // 404 Not Found
    }

    // You can add more exception handlers here for other custom exceptions
}

