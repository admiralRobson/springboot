package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DrugModel;
import com.example.demo.service.DrugService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DrugController {
	
	private final DrugService drugService;
	
	@GetMapping("/drugs")
	public List<DrugModel> getDrugs() {
		return drugService.getDrugs();
	}
	
	@GetMapping("/drugs/{id}")
	public DrugModel getSingleDrug(@PathVariable long id)
	{
		return drugService.getSingleDrug(id);
	}
	
	
}
