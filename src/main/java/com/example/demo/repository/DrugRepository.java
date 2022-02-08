package com.example.demo.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DrugModel;


@Repository
public interface DrugRepository extends JpaRepository<DrugModel, Long> {

}
