package com.example.demo.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.controller.BrandDtoMapper;
import com.example.demo.model.BrandModel;
import com.example.demo.model.dtos.BrandDto;
import com.example.demo.repository.BrandRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandService {

	private final BrandRepository brandRepository;
	
	
	@Cacheable(cacheNames = "getBrands")
	public List<BrandModel> getBrands(int page, int size,String sort) {
		//Sort.Direction.ASC;
		
		PageRequest pageReq = PageRequest.of(page, size,Direction.ASC,"id");
		//PageRequest pageReq = PageRequest.of(page, size,Sort.Direction.fromString(sortDir),sort);
				return brandRepository.findBrandModels(pageReq);
	}
	
	
	@Cacheable(cacheNames = "getSingleBrand",key = "#id")
	public BrandDto getSingleBrand(long id) {
		return BrandDtoMapper.mapToBrandDto(brandRepository.findById(id)
				.orElseThrow());
		
	}
	
	@CacheEvict(cacheNames = "getBrands")
	public void deletebrands() {
		brandRepository.deleteAll();
		
	}
	
	
	@CacheEvict(cacheNames = "getSingleBrand", key = "#id")
	public void deleteBrand(long id) {
		brandRepository.deleteById(id);
	}
	
}
