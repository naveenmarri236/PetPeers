package com.hcl.cs.service;

import java.util.Set;

import com.hcl.cs.model.Pet;
import com.hcl.cs.model.User;

public interface UserService {
	
	public void buyPet(Long userId, Pet pet);
	
	public void saveUser(User user);

	public Set<Pet> getPetById(Long userId);

	//public void authenticateUser(User user);

	
	
	
	public void registerUser(User user);
	public User authenticateUser(User user);

	public boolean userAuthentication(User user);
	
	
	
	

}
