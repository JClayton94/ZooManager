package com.josh.ZooManager.appController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josh.ZooManager.SpringBootException.ResourceNotFoundException;
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
	
	@PostMapping("/createAnimal")
	public AnimalsDataModel createAnimal(@Valid @RequestBody AnimalsDataModel sdm) {
		
		return repo.save(sdm);
		
	}
	
	@GetMapping("/animal/{id}")
	public AnimalsDataModel getAnimalbyID(@PathVariable(value = "id")Long ID){
		return repo.findById(ID).orElseThrow(() -> new ResourceNotFoundException("AnimalsDataModel", "ID", ID));
	}

	
	@PutMapping("/animal/{id}")
	public AnimalsDataModel updateAnimal(@PathVariable(value = "id")Long animalID, @Valid @RequestBody AnimalsDataModel animalDetails) {
		
		AnimalsDataModel animal  = repo.findById(animalID).orElseThrow(() -> new ResourceNotFoundException("Person", "id", animalID));
		
		animal.setSpeices(animalDetails.getSpeices());
		
		return repo.save(animal);
	}
	
	@DeleteMapping("/animal/{id}")
	public ResponseEntity<?> deleteAnimal(@PathVariable(value = "id")Long animalID){
		
		AnimalsDataModel animal  = repo.findById(animalID).orElseThrow(() -> new ResourceNotFoundException("Person", "id", animalID));
		
		repo.delete(animal);
		
		return ResponseEntity.ok().build();
		
	}
	
	
	

}

