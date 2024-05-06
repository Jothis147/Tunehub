package com.music.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.entity.User;
import com.music.repository.UserRepository;
import com.music.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public boolean emailExists(User user) {
		User existingUser=userRepository.findByEmail(user.getEmail());
		if(existingUser!=null) {
			System.out.println("Present");
			return true;
		}else {
			System.out.println("Absent");
			return false;
		}
	}

	@Override
	public boolean validUser(String email, String password) {
		
		User user = userRepository.findByEmail(email);
		String dbpwd=user.getPassword();
		if(password.equals(dbpwd)) {
			return true;
		}else {
		return false;
		}
	}

	@Override
	public boolean getRole(String email) {
		User user = userRepository.findByEmail(email);
		String role=user.getRole();
		if(role.equals("admin")) {
			return true;
		}else {
			return false;	
		}
	}

	@Override
	public User getUser(String mail) {
		
		return userRepository.findByEmail(mail);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

	



}
