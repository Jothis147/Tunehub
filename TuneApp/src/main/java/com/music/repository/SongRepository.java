package com.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

	Song findByName(String name);

}
