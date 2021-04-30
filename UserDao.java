package com.hcl.cs.dao;

import java.util.List;
import java.util.Set;

import com.hcl.cs.model.Pet;
import com.hcl.cs.model.User;

public interface UserDao {



	public void buyPet(Long userId, Pet pet);

	public void saveUser(User user);

	//public void authenticateUser(User user);
	
	
public   Set<Pet> getMyPetsById(Long userId);

	public void registerUser(User user);
	public User authenticateUser(User user);

	public boolean userAuthentication(User user);
	

}
