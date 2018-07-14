package com.example.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.bank.model.Place;
import com.example.bank.service.PlaceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/places")
public class PlaceController {
	
	@Autowired
	private PlaceService placeService;
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Place>  getPlaces() {
		
		
		return placeService.getAll();
		
	}

}
