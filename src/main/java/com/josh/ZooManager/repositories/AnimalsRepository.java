package com.josh.ZooManager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josh.ZooManager.dataModels.AnimalsDataModel;

public interface AnimalsRepository extends JpaRepository<AnimalsDataModel, Long> {
	
	 List<AnimalsDataModel> findBySpeices(String vehicleType);

	 
}

