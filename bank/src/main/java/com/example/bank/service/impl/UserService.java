package com.example.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.User;
import com.example.bank.repository.UserRepository;
import com.example.bank.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findOneByEmail(String email) {
		
		return userRepository.findOneByEmail(email);
	}

	@Override
	public User insert(User user) {
		
		return userRepository.save(user);
	}

	
}
