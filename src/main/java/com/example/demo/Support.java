package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Support {
	
	private String url; 
	private String text;
	
	@Override
	public String toString() {
		return "url:" + url + ",text:" + text;
	}

}
