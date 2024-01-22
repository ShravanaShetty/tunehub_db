package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Service.Songservice;
import com.example.demo.entity.Song;

@Controller
public class SongController {
	@Autowired
	Songservice service;

	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song sg) {
		boolean songstatus=service.songExists(sg.getName());
		if(songstatus==false) {
		service.addSong(sg);
		System.out.println("Song added sucessfully");
		}
		else {
			System.out.println("Song alreay exists");
		}
		return "adminhome";}
		
		
		@GetMapping("/viewsongs")
		public String viewsongs(Model model) {
			List<Song>songsList=service.fetchAllSongs();
			model.addAttribute("songs",songsList);
			return "displaySongs";
			
			
			
		}
		
		@GetMapping("/playsongs")
		public String playsongs(Model model) {
			
		boolean premiumuser=true;
		if(premiumuser==true) {
			List<Song>songsList=service.fetchAllSongs();
			model.addAttribute("songs",songsList);
			return "displaySongs";
			
		}
		else {
			return "Makepayment";
		}
			


			
		
}
		

}
