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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.microservices.upload.dto.Song;
import com.microservices.upload.service.SongService;

/**
 * @author pawar
 * 
 * API to upload song and get song details.
 *
 */
@RestController
public class UploadSongController {

	private Logger logger = LoggerFactory.getLogger(UploadSongController.class);
	
	@Autowired
	private SongService songService;

	
	/**
	 * @param id
	 * @return Song details as per the id
	 */
	@GetMapping("/album/song/{id}")
	public Song retrieveSongByID(@PathVariable long id) {
		logger.info("UploadSongController Method retrieveSongByID ID " + id);
		return songService.fetchSongById(id);
	}

	/**
	 * @return all songs
	 */
	@GetMapping("/album/song")
	public List<Song> retrieveSongs() {
		logger.info("UploadSongController Method retrieveSongs");
		return songService.fetchAllSongs();
		 
	}
	
	/**
	 * @param songFile
	 * @return 
	 *  Upload song
	 */
	@PostMapping("/album/song")
	public Song uploadSong(@RequestParam("file") MultipartFile songFile) {
		logger.info("UploadSongController Method uploadSong");
		return songService.save(songFile);
	}
	
	/**
	 * @param id
	 * @return
	 * delete song by id
	 */
	@DeleteMapping("/album/song/id")
	public Song deleteSongById(@PathVariable String id) {
		logger.info("UploadSongController Method deleteSongById");
		return null;
	}
	
	/**
	 * @param pageable
	 * @return
	 * return song per page with size
	 */
	@RequestMapping(value = "/listPageable", method = RequestMethod.GET)
	Page<Song> songPageable(Pageable pageable) {
		logger.info("UploadSongController Method employeesPageable");
		return songService.findAll(pageable);

	}
}
