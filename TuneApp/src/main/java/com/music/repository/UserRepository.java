package com.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);

	

}
