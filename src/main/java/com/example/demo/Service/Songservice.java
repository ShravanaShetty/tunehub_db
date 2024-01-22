package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Song;

public interface Songservice {

	public void addSong(Song sg);

	public List<Song> fetchAllSongs();

	public boolean songExists(String name);

	public void updateSong(Song s);

	
	

}
