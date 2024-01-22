package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Song;


public interface SongRepository  extends JpaRepository<Song,Integer> {

	Song findByName(String name);

}
