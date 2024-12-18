package com.example.demo.exception;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    // Constructor
    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    // Getter for timestamp
    public Date getTimestamp() {
        return timestamp;
    }

    // Setter for timestamp
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter for details
    public String getDetails() {
        return details;
    }

    // Setter for details
    public void setDetails(String details) {
        this.details = details;
    }
}
