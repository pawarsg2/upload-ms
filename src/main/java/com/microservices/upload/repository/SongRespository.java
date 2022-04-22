package com.microservices.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.upload.dto.Song;

/**
 * @author pawar
 * Repository for song data base operations
 */
@Repository
public interface SongRespository extends JpaRepository<Song, Long> {

}
