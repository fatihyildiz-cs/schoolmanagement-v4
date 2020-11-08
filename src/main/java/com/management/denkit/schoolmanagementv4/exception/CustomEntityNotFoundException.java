package com.management.denkit.schoolmanagementv4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.PersistenceException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomEntityNotFoundException extends PersistenceException {

    public CustomEntityNotFoundException(String message) {
        super(message);
    }

}
