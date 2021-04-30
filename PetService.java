package com.hcl.cs.service;

import java.util.List;

import com.hcl.cs.model.Pet;

public interface PetService {

	public List<Pet> getAllPets();

	public void addPet(Pet pet);

	public Pet getPetByPetId(Long petId);

		
}
