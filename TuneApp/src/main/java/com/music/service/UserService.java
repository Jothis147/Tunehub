package com.music.service;

import com.music.entity.User;


public interface UserService {
	public void saveUser(User user);

	boolean emailExists(User user);

	public boolean validUser(String email, String password);

	public boolean getRole(String email);

	public User getUser(String mail);

	public void updateUser(User user);

	


}
