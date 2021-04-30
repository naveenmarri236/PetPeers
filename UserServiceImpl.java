package com.hcl.cs.service;

import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.cs.dao.UserDao;
import com.hcl.cs.model.Pet;
import com.hcl.cs.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	Logger logger=Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;

	@Override
	public void saveUser(User user) {
		logger.info("Inside saveUser()");
		userDao.saveUser(user);
	}

	@Override
	public void buyPet(Long userId, Pet pet) {
		logger.info("Inside buyPet()");
		userDao.buyPet(userId, pet);

	}

	@Override
	public Set<Pet> getPetById(Long userId) {
		logger.info("Inside getPetById()");
		return userDao.getMyPetsById(userId);

	}

	@Override
	public void registerUser(User user) {
		logger.info("Inside registerUser()");
		user.setUserId(new Random().nextInt(99999) + 10000L);
		System.out.print("USER =========================>>" + user);
		userDao.registerUser(user);
	}

	@Override
	public User authenticateUser(User user) {
		logger.info("Inside authenticateUser()");
		System.out.print("authenticateUser ()   =========================>>" + user);
		System.out.println(user);
		return userDao.authenticateUser(user);
	}

	@Override
	public boolean userAuthentication(User user) {
		logger.info("Inside userAuthentication()");
		System.out.print("userAuthentication ()   =========================>>" + user);
		System.out.println(user);
		return userDao.userAuthentication(user);
	}

}
