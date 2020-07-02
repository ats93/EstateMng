package com.arseny.estatemng.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<?> handleException(NoSuchElementException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorException(e.getLocalizedMessage(), 404, "Not found"));
    }
}
