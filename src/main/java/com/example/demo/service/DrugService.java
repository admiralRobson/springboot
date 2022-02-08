package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.DrugModel;
import com.example.demo.repository.DrugRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DrugService {

	
	private final DrugRepository drugRepository;
	
	public List<DrugModel> getDrugs() {
		// pobiera wszystkie leki z bazy
		return drugRepository.findAll();
	}
	
	public DrugModel getSingleDrug(long id) {
		return drugRepository.findById(id).orElseThrow(); 
	} 
	
	
}
