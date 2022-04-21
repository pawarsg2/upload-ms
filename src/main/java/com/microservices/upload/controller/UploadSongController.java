package com.microservices.upload.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.microservices.upload.dto.Song;
import com.microservices.upload.repository.SongRespository;
import com.microservices.upload.service.SongService;

@RestController
public class UploadSongController {

	private Logger logger = LoggerFactory.getLogger(UploadSongController.class);
	
	@Autowired
	private SongService songService;

	
	@GetMapping("/album/song/{id}")
	public Song retrieveSongByID(@PathVariable long id) {
		logger.info("retrieveSongByID");
		return songService.fetchSongById(id);
	}

	@GetMapping("/album/song")
	public List<Song> retrieveSongs() {
		logger.info("retrieveSongByID");
		return songService.fetchAllSongs();
		 
	}
	
	@PostMapping("/album/song")
	public Song uploadSong(@RequestParam("file") MultipartFile songFile) {
		logger.info("retrieveSongByID");
		return songService.save(songFile);
	}
	
	@DeleteMapping("/album/song/id")
	public Song deleteSongById(@PathVariable String id) {
		logger.info("retrieveSongByID");
		return null;
	}
	
	@RequestMapping(value = "/listPageable", method = RequestMethod.GET)
	Page<Song> employeesPageable(Pageable pageable) {
		return songService.findAll(pageable);

	}
}
