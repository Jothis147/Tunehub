package com.music.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.entity.Song;
import com.music.repository.SongRepository;
import com.music.service.SongService;

@Service
public class SongServiceImpl implements SongService{
	
	@Autowired
	SongRepository songRepository;
	
	@Override
	public void saveSong(Song song) {
		songRepository.save(song);
		
	}

	@Override
	public boolean songExists(Song song) {
		Song existingSong=songRepository.findByName(song.getName());
		if(existingSong!=null) {
			System.out.println("Present");
			return true;
		}else {
			System.out.println("Absent");
			return false;
		}
	}

	@Override
	public List<Song> fetchAllsongs() {
		List<Song> song = songRepository.findAll();
		return song;
	}

	@Override
	public void updateSong(Song song) {
		songRepository.save(song);
		
	}

	
}
