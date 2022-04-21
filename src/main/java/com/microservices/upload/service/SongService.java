package com.microservices.upload.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.microservices.upload.dto.Song;
import com.microservices.upload.exception.SongNotFoundException;
import com.microservices.upload.repository.SongRespository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SongService {
	
	@Autowired
	private SongRespository songRepo;
	
	public Song save(MultipartFile multipartFile){
        Song song;
		try {
			song = new Song(multipartFile.getName(), multipartFile.getContentType(), multipartFile.getBytes());
			return songRepo.save(song);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Song fetchSongById(Long id) {	
		
        Song song;
        if (songRepo.findById(id).isEmpty()) {
            throw new SongNotFoundException();
        } else {
        	song = songRepo.findById(id).get();
        }
        return song;
		
	}
	
	public List<Song> fetchAllSongs() {	
		return songRepo.findAll();
		
	}
	
	public Page<Song> findAll(Pageable pageable) {	
		return songRepo.findAll(pageable);
		
	}

}
