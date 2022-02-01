package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;



@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public  class Data {
	private int id; 
	private String name; 
	private int year; 
	private String color; 
	private String pantone_value;
	
	@Override
	public String toString()
	{
		return  "id" + id + ",name" + name + ",year" + year + ",color:" + color + ",pantone_value:" + pantone_value;		
	}
}
