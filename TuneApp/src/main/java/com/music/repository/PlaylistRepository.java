package com.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

	Playlist findByName(String name);

}
