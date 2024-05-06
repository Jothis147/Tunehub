package com.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.music.entity.Song;
import com.music.service.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService songService;
	
	@PostMapping("/addsongs")
	public String addSong(@ModelAttribute Song song) {
		boolean songExists=songService.songExists(song);
		if(songExists==false) {
		songService.saveSong(song);
		System.out.println("Song added successfully");
		}else {
			System.out.println("Duplicate song");
		}
		return "adminhome";
	}
	
	@GetMapping("/viewsongs")
	public String viewSongs(Model model) {
		
		List<Song> songslist = songService.fetchAllsongs();
		model.addAttribute("songs",songslist);
		System.out.println(songslist);
		return "viewsongs";
		}
	
	@GetMapping("/playsongs")
	public String playSongs(Model model) {
		
		boolean premium=true;
		if(premium) {
		List<Song> songslist = songService.fetchAllsongs();
		model.addAttribute("songs",songslist);
		System.out.println(songslist);
		return "viewsongs";
		}else {
			return"payment form";
		}
	}
	
	
	
	
	
	

}
