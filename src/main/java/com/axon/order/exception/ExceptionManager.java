package com.axon.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ErrorMessage(LocalDateTime.now(),
                ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentExceptionHandler(Exception ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ErrorMessage(LocalDateTime.now(),
                        ex.getMessage()));
    }
}
