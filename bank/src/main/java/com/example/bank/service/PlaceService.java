package com.example.bank.service;

import java.util.List;

import com.example.bank.model.Place;

public interface PlaceService {

	List<Place> getAll();
	Place getPlaceById(Long id);
}
