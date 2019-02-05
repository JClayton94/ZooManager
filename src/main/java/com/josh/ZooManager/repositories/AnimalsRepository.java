package com.josh.ZooManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josh.ZooManager.dataModels.AnimalsDataModel;

public interface AnimalsRepository extends JpaRepository<AnimalsDataModel, Long> {

	 
}

