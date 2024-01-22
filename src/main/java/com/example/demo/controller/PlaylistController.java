package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Service.PlaylistService;
import com.example.demo.Service.Songservice;
import com.example.demo.entity.Playlist;
import com.example.demo.entity.Song;

@Controller
public class PlaylistController {
	@Autowired
	Songservice songService;
	
	@Autowired
	PlaylistService playlistService;
	
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {
		List<Song>songList=songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createPlaylist";
	}
	
	
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist){
		playlistService.addPlaylist(playlist);
		
		//updating the table
		List<Song>songList=playlist.getSongs();
		for(Song s : songList) {
			s.getPlaylists().add(playlist);
			songService.updateSong(s);
			
		}
		return "adminhome";
		
	}
	@GetMapping("/viewPlaylist")
	public String viewPlaylist(Model model) {
		List<Playlist>allPlaylists=playlistService.fetchAllPlaylists();
		model.addAttribute("allPlaylist", allPlaylists);
		return "displayPlaylists";
	
	}

}
