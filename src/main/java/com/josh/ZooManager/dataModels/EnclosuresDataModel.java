package com.josh.ZooManager.dataModels;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "enclosures")
@EntityListeners(AuditingEntityListener.class)
public class EnclosuresDataModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private String Name;

	private String Features;
	
	public EnclosuresDataModel() {
		
	}

	public EnclosuresDataModel(Long iD, String name, String features) {
		ID = iD;
		Name = name;
		Features = features;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFeatures() {
		return Features;
	}

	public void setFeatures(String features) {
		Features = features;
	}

}
