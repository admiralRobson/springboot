package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BrandModel;
import com.example.demo.model.DrugModel;
import com.example.demo.service.BrandService;
import com.example.demo.service.DrugService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class BrandController {
	
	private final BrandService brandService;
	
	@GetMapping("/brands")
	public List<BrandModel> getBrands() {
		return brandService.getBrands();
	}
	
	@GetMapping("/brands/{id}")
	public BrandModel getSingleBrand(@PathVariable long id)
	{
		return brandService.getSingleBrand(id);
	}

}
