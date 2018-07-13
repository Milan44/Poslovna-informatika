package com.example.bank.service;

import com.example.bank.model.User;

public interface IUserService {

	User findOneByEmail(String email);
	User insert(User user);
}
