package com.hcl.cs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="PET")
public class Pet {
	
	@Id
	@Column(name="PETID")
	@NotNull
	private Long petId;
	
	@NotEmpty
	@Column(name="PETNAME")
	private String petName;
	
	@NotNull
	@Min(value=0)
	@Max(value=99)
	@Column(name="PETAGE")
	private Integer petAge;
	
	@NotEmpty
	@Column(name="PETPlACE")
	private String petPlace;
	
	@Transient
	private Boolean buy;

	public Boolean getBuy() {
		return buy;
	}

	public void setBuy(Boolean buy) {
		this.buy = buy;
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Integer getPetAge() {
		return petAge;
	}

	public void setPetAge(Integer petAge) {
		this.petAge = petAge;
	}

	public String getPetPlace() {
		return petPlace;
	}

	public void setPetPlace(String petPlace) {
		this.petPlace = petPlace;
	}

	public Pet(Long petId, String petName, Integer petAge, String petPlace) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petAge = petAge;
		this.petPlace = petPlace;
	}

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pet (petId=" + petId + ", petName=" + petName + ", petAge=" + petAge + ", petPlace=" + petPlace + " , buy=" +buy+")";
	}
	
}
