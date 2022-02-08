package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BrandModel;

@Repository
public interface BrandRepository extends JpaRepository<BrandModel, Long>{

}
