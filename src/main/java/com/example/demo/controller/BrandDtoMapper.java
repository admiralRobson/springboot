package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.BrandModel;
import com.example.demo.model.dtos.BrandDto;
import com.example.demo.service.BrandService;

import lombok.RequiredArgsConstructor;


public class BrandDtoMapper {

	private BrandDtoMapper() {
	}
	
	public static List<BrandDto> mapToBrandDtos (List<BrandModel> brands) {
		return brands.stream()
				.map(brand -> mapToBrandDto(brand))
				.collect(Collectors.toList());
	}
	
	public static BrandDto mapToBrandDto(BrandModel brand) {
		return BrandDto.builder()
				.id(brand.getId())
				.name(brand.getName())
				.build();
	}	
	
}
