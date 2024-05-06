package com.music.service;

import java.util.List;

import com.music.entity.Playlist;
import com.music.entity.Song;

public interface PlaylistService {


	void savePlaylist(Playlist playlist);

	boolean playlistExists(Playlist playlist);

	List<Playlist> fetchAllplaylist();

}
