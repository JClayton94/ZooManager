package com.josh.ZooManager.dataModels;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String Speices;

	private String Name;

	@NotBlank
	private Long EnclosureID;

	@NotBlank
	private Long KeeperID;

	private String Notes;

	public AnimalsDataModel(Long iD, @NotBlank String speices, String name, @NotBlank Long enclosureID,
			@NotBlank Long keeperID, String notes) {
		ID = iD;
		Speices = speices;
		Name = name;
		EnclosureID = enclosureID;
		KeeperID = keeperID;
		Notes = notes;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getSpeices() {
		return Speices;
	}

	public void setSpeices(String speices) {
		Speices = speices;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Long getEnclosureID() {
		return EnclosureID;
	}

	public void setEnclosureID(Long enclosureID) {
		EnclosureID = enclosureID;
	}

	public Long getKeeperID() {
		return KeeperID;
	}

	public void setKeeperID(Long keeperID) {
		KeeperID = keeperID;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

}
