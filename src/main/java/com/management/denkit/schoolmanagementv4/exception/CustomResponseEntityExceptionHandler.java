package com.management.denkit.schoolmanagementv4.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {

        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(customExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomEntityNotFoundException.class)
    public final ResponseEntity<Object> handleEntityNotFoundException(CustomEntityNotFoundException ex, WebRequest request) throws Exception {

        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(customExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomEntityAlreadyExistsException.class)
    public final ResponseEntity<Object> handleEntityAlreadyExistsException(CustomEntityAlreadyExistsException ex, WebRequest request) throws Exception {

        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(customExceptionResponse, HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(new Date(), "Validation Failed :(", ex.getBindingResult().toString());

        return new ResponseEntity(customExceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
