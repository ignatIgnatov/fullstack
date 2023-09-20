package com.example.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class ExceptionHandlerAdvice {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e
                .getBindingResult()
                .getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ImageNotFoundException.class})
    public Map<String, String> imageNotFound(ImageNotFoundException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", e.getMessage());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UserNotFoundException.class})
    public Map<String, String> userNotFound(UserNotFoundException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", e.getMessage());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UserExistException.class})
    public Map<String, String> userExist(UserExistException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", e.getMessage());
        return errors;
    }
}
