package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BrandModel;

@Repository
public interface BrandRepository extends JpaRepository<BrandModel, Long>{
	
	@Query("select distinct b from BrandModel b join fetch b.drugs")
	List<BrandModel> findBrandModels(Pageable page);
	
	
	
}
