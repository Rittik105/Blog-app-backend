package com.springtutorial.blog.exceptions;

import com.springtutorial.blog.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ResourceNotFound.class})
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFound e){
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
        Map<String, String> responses = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();

            responses.put(fieldName, message);
        });

        return new ResponseEntity<>(responses, HttpStatus.BAD_REQUEST);
    }
}
