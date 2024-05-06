package com.music.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.entity.Playlist;
import com.music.entity.Song;
import com.music.repository.PlaylistRepository;
import com.music.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{
	
	@Autowired
	PlaylistRepository playlistRepository;



	@Override
	public void savePlaylist(Playlist playlist) {
		playlistRepository.save(playlist);
	}



	@Override
	public boolean playlistExists(Playlist playlist) {
		Playlist existingPlaylist=playlistRepository.findByName(playlist.getName());
		if(existingPlaylist!=null) {
			System.out.println("Present");
			return true;
		}else {
			System.out.println("Absent");
			return false;
		}
	}



	@Override
	public List<Playlist> fetchAllplaylist() {
		List<Playlist> 	playlist=playlistRepository.findAll();	
		return playlist;
	}

}
