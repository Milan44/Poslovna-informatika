package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Place;
import com.example.bank.repository.PlaceRepository;
import com.example.bank.service.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService {

	
	@Autowired
	private PlaceRepository placeRepository;
	
	
	@Override
	public List<Place> getAll() {
		// TODO Auto-generated method stub
		return placeRepository.findAll();
	}


	@Override
	public Place getPlaceById(Long id) {
		// TODO Auto-generated method stub
		return placeRepository.findOneById(id);
	}
	
	@Override
	public List<Place> findAll() {
		return placeRepository.findAll();
	}

	@Override
	public Place findById(Long id) {
		return placeRepository.findById(id).get();
	}
	

}


