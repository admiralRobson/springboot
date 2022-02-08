package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BrandModel;
import com.example.demo.repository.BrandRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandService {

	private final BrandRepository brandRepository;
	
	public List<BrandModel> getBrands() {
		return brandRepository.findAll();
	}
	
	public BrandModel getSingleBrand(long id) {
		return brandRepository.findById(id)
				.orElseThrow();
		
	}
	
	
}
