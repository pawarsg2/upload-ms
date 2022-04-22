package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.microservices.upload.dto.Song;
import com.microservices.upload.repository.SongRespository;
import com.microservices.upload.service.SongService;

@ExtendWith(MockitoExtension.class)
public class TestSongService {
	
	@InjectMocks
	SongService songService;
	
	@Mock
	SongRespository songRepo;
	
	@Test
	void testFetchSongById() {
		Optional<Song> s = Optional.ofNullable(new Song(1001L,"test song"));
		when(songRepo.findById(anyLong())).thenReturn(s);
		Song songTest  =songService.fetchSongById(1001L);
		assertEquals(songTest.getTitle(), "test song");
		
	}
	

}
