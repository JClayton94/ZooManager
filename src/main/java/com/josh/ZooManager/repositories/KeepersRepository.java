package com.josh.ZooManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josh.ZooManager.dataModels.KeepersDataModel;

public interface KeepersRepository extends JpaRepository<KeepersDataModel, Long> {

	 
}

