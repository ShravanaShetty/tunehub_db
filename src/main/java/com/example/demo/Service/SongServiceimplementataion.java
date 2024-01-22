package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.SongRepository;
import com.example.demo.entity.Song;


@Service
public class SongServiceimplementataion implements Songservice  {
	
	@Autowired
	SongRepository repo;

	@Override
	public void addSong(Song sg) {
		repo.save(sg);
		
		
	}

	@Override
	public List<Song> fetchAllSongs() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean songExists(String name) {
		Song sg=repo.findByName(name);
		if(sg==null) {
		return false;}
	else {
		return true;}
	}

	@Override
	public void updateSong(Song s) {
		repo.save(s);
	}

	
}
