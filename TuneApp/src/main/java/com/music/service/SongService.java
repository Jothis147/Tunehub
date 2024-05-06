package com.music.service;

import java.util.List;

import com.music.entity.Song;

public interface SongService {

	public void saveSong(Song song);

	public boolean songExists(Song song);

	public List<Song> fetchAllsongs();

	public void updateSong(Song song);

	

}
