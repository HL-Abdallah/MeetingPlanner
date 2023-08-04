package com.example.meetingplanner.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
}
