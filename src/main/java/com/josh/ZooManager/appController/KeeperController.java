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
import com.josh.ZooManager.dataModels.KeepersDataModel;
import com.josh.ZooManager.repositories.KeepersRepository;

@RestController
@RequestMapping("/keepers")
public class KeeperController {
	
	@Autowired 
	KeepersRepository repo;

	@CrossOrigin
	@GetMapping("/allKeepers")
	public List<KeepersDataModel> getAllKeepers(){
		
		return repo.findAll();
	}
	
	@PostMapping("/create")
	public KeepersDataModel createKeeper(@Valid @RequestBody KeepersDataModel sdm) {
		
		return repo.save(sdm);
		
	}
	
	@GetMapping("/keeper/{id}")
	public KeepersDataModel getKeeperbyID(@PathVariable(value = "id")Long ID){
		return repo.findById(ID).orElseThrow(() -> new ResourceNotFoundException("KeepersDataModel", "ID", ID));
	}

	
	@PutMapping("/keeper/{id}")
	public KeepersDataModel updateKeeper(@PathVariable(value = "id")Long keeperID, @Valid @RequestBody KeepersDataModel keeperDetails) {
		
		KeepersDataModel keeper  = repo.findById(keeperID).orElseThrow(() -> new ResourceNotFoundException("Person", "id", keeperID));
		
		keeper.setName(keeperDetails.getName());
		
		return repo.save(keeper);
	}
	
	@DeleteMapping("/keeper/{id}")
	public ResponseEntity<?> deleteKeeper(@PathVariable(value = "id")Long keeperID){
		
		KeepersDataModel keeper  = repo.findById(keeperID).orElseThrow(() -> new ResourceNotFoundException("Person", "id", keeperID));
		
		repo.delete(keeper);
		
		return ResponseEntity.ok().build();
		
	}

}
