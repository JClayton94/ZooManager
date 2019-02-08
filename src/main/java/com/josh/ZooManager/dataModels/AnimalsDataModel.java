package com.josh.ZooManager.dataModels;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "animals")
@EntityListeners(AuditingEntityListener.class)
public class AnimalsDataModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@NotBlank
	private String speices;

	private String name;

	private String notes;

	private Long enclosureID;

	private Long keeperID;

	
	public AnimalsDataModel() {
	}

	public AnimalsDataModel(Long iD, @NotBlank String speices, String name, String notes, Long enclosureID,
			Long keeperID) {
		ID = iD;
		this.speices = speices;
		this.name = name;
		this.notes = notes;
		this.enclosureID = enclosureID;
		this.keeperID = keeperID;
	}

	public Long getEnclosureID() {
		return enclosureID;
	}

	public void setEnclosureID(Long enclosureID) {
		this.enclosureID = enclosureID;
	}

	public Long getKeeperID() {
		return keeperID;
	}

	public void setKeeperID(Long keeperID) {
		this.keeperID = keeperID;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getSpeices() {
		return speices;
	}

	public void setSpeices(String speices) {
		this.speices = speices;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
