package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DRUG")
@Getter
@Setter
public class DrugModel {
	@Id
	@Column(name = "ID")
	private long id; 
	@Column(name = "BRAND_NAME")
	private String brand_name; 
	@Column(name = "NAME")
	private String name;
	@Column(name = "BLOZ")
	private String bloz;
}
