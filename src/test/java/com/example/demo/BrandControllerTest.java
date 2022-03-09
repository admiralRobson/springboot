package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.matches;


import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.discovery.SelectorResolver.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.BrandModel;
import com.example.demo.repository.BrandRepository;
import com.example.demo.service.BrandService;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
public class BrandControllerTest {
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private BrandRepository brandRepository;
	
	
	@Test
	void shouldgetSinglePost() throws Exception {
		
		BrandModel newbrand = new BrandModel();
		newbrand.setName("Fiorda");
		brandRepository.save(newbrand);
		
		MvcResult mvcResult =  mvc.perform(MockMvcRequestBuilders.get("/brands/1"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().is(200))
		.andReturn();
		
	BrandModel brand = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BrandModel.class); 	
	//assertEquals(brand.getId(), 1L);
	assertEquals(newbrand.getId(), 0L);
	
	}
}
