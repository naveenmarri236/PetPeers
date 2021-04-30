package com.hcl.cs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.cs.dao.PetDao;
import com.hcl.cs.model.Pet;

@Service
@Transactional
public class PetServiceImpl implements PetService{
	
	Logger logger=Logger.getLogger(PetServiceImpl.class);
	
	@Autowired
	private PetDao petDao;

	@Override
	public List<Pet> getAllPets() {
		logger.info("Inside getAllPets()");
		List<Pet> petList=petDao.getAllPets();
		return petList;
	}

	@Override
	public void addPet(Pet pet) {
		logger.info("Inside addPet()");
		petDao.addPet(pet);
		
	}

	@Override
	public Pet getPetByPetId(Long petId) {
		logger.info("Inside getPetByPetId()");
		return petDao.getPetByPetId(petId);
	}

	

}
