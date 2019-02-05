package com.josh.ZooManager.appController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josh.ZooManager.dataModels.AnimalsDataModel;
import com.josh.ZooManager.repositories.AnimalsRepository;

@RestController
@RequestMapping("/animals")
public class AnimalsController {
	
	@Autowired 
	AnimalsRepository repo;

	@CrossOrigin
	@GetMapping("/allAnimals")
	public List<AnimalsDataModel> getAllAnimals(){
		
		return repo.findAll();
	}
	
	
	

}

