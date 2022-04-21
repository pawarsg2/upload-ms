package com.microservices.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microservices.upload.dto.Song;
import com.microservices.upload.service.SongService;

@SpringBootApplication
public class UploadApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(UploadApplication.class, args);
	
	}

}
