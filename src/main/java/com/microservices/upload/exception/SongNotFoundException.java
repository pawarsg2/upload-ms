package com.microservices.upload.exception;

public class SongNotFoundException extends RuntimeException {
    private String message;
    public SongNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public SongNotFoundException() {
    }
}
