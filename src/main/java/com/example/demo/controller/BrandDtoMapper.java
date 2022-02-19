package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.BrandModel;
import com.example.demo.model.dtos.BrandDto;

public class BrandDtoMapper {
	
	
	private BrandDtoMapper() {
	}
	
	public static List<BrandDto> mapToBrandDtos (List<BrandModel> brands) {
		return brands.stream()
				.map(brand -> mapToBrandDto(brand))
				.collect(Collectors.toList());
	}
	
	
	
	
	private static BrandDto mapToBrandDto(BrandModel brand) {
		return BrandDto.builder()
				.id(brand.getId())
				.name(brand.getName())
				.build();
	}
	
	
}
