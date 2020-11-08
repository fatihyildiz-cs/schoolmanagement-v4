package com.management.denkit.schoolmanagementv4.exception;

import java.util.Date;

public class CustomExceptionResponse {

    private Date timeStamp;
    private String message;
    private String details;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public CustomExceptionResponse(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
