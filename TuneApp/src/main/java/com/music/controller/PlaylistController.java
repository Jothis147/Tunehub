package com.music.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.music.entity.Playlist;
import com.music.entity.Song;
import com.music.service.PlaylistService;
import com.music.service.SongService;



@Controller
public class PlaylistController {

	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	SongService songService;
	
	@GetMapping("/createplaylist")
	public String createplaylist(Model model) {
		List<Song> songsList = songService.fetchAllsongs();
		model.addAttribute("songs",songsList);
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		boolean playlistExists=playlistService.playlistExists(playlist);
		if(playlistExists==false) {
			playlistService.savePlaylist(playlist);
			System.out.println("Playlist added successfully");
		}else {
			System.out.println("Duplicate Playlist");
		}
		List<Song> songs=playlist.getSongs();
		for(Song song:songs) {
			song.getPlaylists().add(playlist);
			songService.updateSong(song);
		}
		
		return "adminhome";
	}
	
	@GetMapping("/viewplaylist")
	public String viewplaylist(Model model) {
		List<Playlist> playlists = playlistService.fetchAllplaylist();
		model.addAttribute("playlists",playlists);
		System.out.println(playlists);
		return "viewplaylist";
		
	}
	
	
}
