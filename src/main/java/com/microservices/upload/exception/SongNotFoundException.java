package com.microservices.upload.exception;

/**
 * @author pawar
 * If song not found by id thow this exception
 */
public class SongNotFoundException extends RuntimeException {
    private String message;
    public SongNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public SongNotFoundException() {
    }
}
