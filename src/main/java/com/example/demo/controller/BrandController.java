package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BrandModel;
import com.example.demo.model.DrugModel;
import com.example.demo.model.dtos.BrandDto;
import com.example.demo.service.BrandService;
import com.example.demo.service.DrugService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class BrandController {
	
	private final BrandService brandService;
	
	
	
	private static int pagesize = 10; 
	
	
	@GetMapping("/brands")
	private List<BrandDto> converttoDto(@RequestParam(required = false) Integer page, String sort) {
		int pagenumber = page != null ? page :0;
		String sortcolumn = sort != null ? sort : "id";
		return BrandDtoMapper.mapToBrandDtos(brandService.getBrands(pagenumber, pagesize, sortcolumn));
	}
	
	@GetMapping("/brands/{id}")
	public BrandDto getSingleBrand(@PathVariable long id)
	{
		return brandService.getSingleBrand(id);
	}
	
	@DeleteMapping("delete_brand/{id}")
	public void deleteBrand(@PathVariable long id) {
		brandService.deleteBrand(id);
	}
	
	
}
