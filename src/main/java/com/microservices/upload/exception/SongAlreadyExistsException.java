package com.microservices.upload.exception;

/**
 * @author pawar
 *  if song exist and try to upload some song throw this exception
 */
public class SongAlreadyExistsException  extends RuntimeException {
    private String message;
    public SongAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
    public SongAlreadyExistsException() {
    }

}
