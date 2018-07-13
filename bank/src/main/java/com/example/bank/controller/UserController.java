package com.example.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.dtos.UserDTO;
import com.example.bank.model.LoginMessage;
import com.example.bank.model.User;
import com.example.bank.service.IUserService;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;
	@RequestMapping(
			value = "/login",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoginMessage loginUser(@RequestBody UserDTO userDTO) {
			
		User u = userService.findOneByEmail(userDTO.getEmail());
			
		String hashed = get_SHA_512_SecurePassword(userDTO.getPassword(), "kravaa&asembler&torta&baka");
		System.out.println(hashed);
		
		if (u != null)
			
		
			if (!hashed.equals(u.getPassword()))
				return LoginMessage.WRONG_PASSWORD;
			
			else
				return LoginMessage.SUCCESS;
		
		else
			return LoginMessage.WRONG_MAIL;

		
	}
	
	public String get_SHA_512_SecurePassword(String passwordToHash, String salt){
		String generatedPassword = null;
		    try {
		         MessageDigest md = MessageDigest.getInstance("SHA-512");
		         md.update(salt.getBytes(StandardCharsets.UTF_8));
		         byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
		         StringBuilder sb = new StringBuilder();
		         for(int i=0; i< bytes.length ;i++){
		            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		         }
		         generatedPassword = sb.toString();
		        } 
		       catch (NoSuchAlgorithmException e){
		        e.printStackTrace();
		       }
		    return generatedPassword;
		}
}
