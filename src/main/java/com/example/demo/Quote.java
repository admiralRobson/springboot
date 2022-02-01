package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Setter;

import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Quote {
	private Data data; 
	private Support support;
	
	@Override
	public String toString() {
		return "Quote{" +
		        "data='" + data + '\'' +
		        ", suppoprt=" + support+
		        '}';
		  }
	}
	