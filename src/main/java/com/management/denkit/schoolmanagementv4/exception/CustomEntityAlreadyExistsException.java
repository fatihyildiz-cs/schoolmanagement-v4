package com.management.denkit.schoolmanagementv4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CustomEntityAlreadyExistsException extends RuntimeException {

    public CustomEntityAlreadyExistsException(String message) {
        super(message);
    }
}
