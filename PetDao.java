package com.hcl.cs.dao;

import java.util.List;

import com.hcl.cs.model.Pet;

public interface PetDao {

	public List<Pet> getAllPets();

	public void addPet(Pet pet);

	public Pet getPetByPetId(Long petId);
}
