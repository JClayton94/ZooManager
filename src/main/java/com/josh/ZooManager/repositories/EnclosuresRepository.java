package com.josh.ZooManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josh.ZooManager.dataModels.EnclosuresDataModel;


public interface EnclosuresRepository extends JpaRepository<EnclosuresDataModel, Long> {

	 
}

