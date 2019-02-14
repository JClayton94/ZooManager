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
import com.josh.ZooManager.dataModels.EnclosuresDataModel;
import com.josh.ZooManager.repositories.EnclosuresRepository;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/enclosures")
public class EnclosureController {
	
	@Autowired 
	EnclosuresRepository repo;

	@GetMapping("/allEnclosures")
	public List<EnclosuresDataModel> getAllEnclosures(){
		
		return repo.findAll();
	}
	
	@PostMapping("/create")
	public EnclosuresDataModel createEnclosure(@Valid @RequestBody EnclosuresDataModel sdm) {
		
		return repo.save(sdm);
		
	}
	
	@GetMapping("/enclosure/{id}")
	public EnclosuresDataModel getEnclosurebyID(@PathVariable(value = "id")Long ID){
		return repo.findById(ID).orElseThrow(() -> new ResourceNotFoundException("EnclosuresDataModel", "ID", ID));
	}

	
	@PutMapping("/enclosure/{id}")
	public EnclosuresDataModel updateEnclosure(@PathVariable(value = "id")Long enclosureID, @Valid @RequestBody EnclosuresDataModel enclosureDetails) {
		
		EnclosuresDataModel enclosure  = repo.findById(enclosureID).orElseThrow(() -> new ResourceNotFoundException("Person", "id", enclosureID));
		
		enclosure.setName(enclosureDetails.getName());
		
		return repo.save(enclosure);
	}
	
	@DeleteMapping("/enclosure/{id}")
	public ResponseEntity<?> deleteEnclosure(@PathVariable(value = "id")Long enclosureID){
		
		EnclosuresDataModel enclosure  = repo.findById(enclosureID).orElseThrow(() -> new ResourceNotFoundException("Person", "id", enclosureID));
		
		repo.delete(enclosure);
		
		return ResponseEntity.ok().build();
		
	}
	

}
