package com.microservices.upload.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.microservices.upload.config.ExceptionMessageConfig;
import com.microservices.upload.exception.SongAlreadyExistsException;
import com.microservices.upload.exception.SongNotFoundException;

/**
 * @author pawar
 * 
 * Global exception handling
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	private ExceptionMessageConfig exceptionMessageConfig;
    
    @ExceptionHandler(value = SongNotFoundException.class)
    public ResponseEntity<String> blogNotFoundException(SongNotFoundException songNotFoundException) {
        return new ResponseEntity<String>(exceptionMessageConfig.getMessage2(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = SongAlreadyExistsException.class)
    public ResponseEntity<String> blogNotFoundException(SongAlreadyExistsException songAlreadyExistsException) {
        return new ResponseEntity<String>(exceptionMessageConfig.getMessage1(), HttpStatus.CONFLICT);
    }
}
