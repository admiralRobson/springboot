package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BRAND")
@Getter
@Setter
public class BrandModel {
	@Id
	private long id; 
	@Column(name = "NAME")
	private String name;
	
	
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "BRAND_NAME") private List<DrugModel> drugs;
	 */
}


