package com.microservices.upload.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.microservices.upload.controller.UploadSongController;
import com.microservices.upload.dto.Song;
import com.microservices.upload.exception.SongNotFoundException;
import com.microservices.upload.repository.SongRespository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pawar
 * Bussiness logic for song
 */
@Component
@Slf4j
public class SongService {
	
	@Autowired
	private SongRespository songRepo;
	private Logger logger = LoggerFactory.getLogger(SongService.class);
	
	public Song save(MultipartFile multipartFile){
		
		logger.info("Start SongService Method save File Name: " + multipartFile.getName());
        Song song = null;
		try {
			song = new Song(multipartFile.getName(), multipartFile.getContentType(), multipartFile.getBytes());
			return songRepo.save(song);
		} catch (IOException e) {
			logger.error(" SongService Method save, Error Message " + e.getMessage());
		}
		logger.info("Exit SongService Method save ");
		return song;
	}
	
	public Song fetchSongById(Long id) {	
		logger.info("Start SongService Method fetchSongById File ID: " + id);
        Song song;
        if (songRepo.findById(id).isEmpty()) {
        	logger.error(" SongService Method save, Error Message Song not found" );
            throw new SongNotFoundException();
        } else {
        	song = songRepo.findById(id).get();
        }
        logger.info("Exit SongService Method fetchSongById File ID: " + id);
        return song;
		
	}
	
	public List<Song> fetchAllSongs() {
		logger.info("SongService Method fetchAllSongs ");
		return songRepo.findAll();
		
		
	}
	
	public Page<Song> findAll(Pageable pageable) {
		logger.info("SongService Method findAll ");
		return songRepo.findAll(pageable);
		
	}

}
