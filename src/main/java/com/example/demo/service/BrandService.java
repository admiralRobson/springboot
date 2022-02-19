package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.BrandModel;
import com.example.demo.repository.BrandRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandService {

	private final BrandRepository brandRepository;
	
	public List<BrandModel> getBrands(int page, int size, String sortDir, String sort) {
		
		PageRequest pageReq = PageRequest.of(page, size,Sort.Direction.fromString(sortDir),sort);
		return brandRepository.findAllBrands(pageReq);
	}
	
	public BrandModel getSingleBrand(long id) {
		return brandRepository.findById(id)
				.orElseThrow();
		
	}
	
	
	public void deleteBrand(long id) {
		brandRepository.deleteById(id);
	}
	
}
