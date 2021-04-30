package com.hcl.cs.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.cs.model.Pet;
import com.hcl.cs.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private static final String User = null;
	
	Logger logger=Logger.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;



	@Override
	public void buyPet(Long userId, Pet pet) {
		logger.info("Inside buyPet()");
		User fetchUserById = (User) sessionFactory.getCurrentSession().get(User.class, userId);
		if (fetchUserById != null) {

			fetchUserById.getPets().add(pet);
			sessionFactory.getCurrentSession().update(fetchUserById);

		}

	}
	
	
	

	@Override
	public void saveUser(User user) {
		logger.info("Inside saveUser()");
		sessionFactory.getCurrentSession().save(user);
	}
	

	@Override
	public void registerUser(User user) {
		logger.info("Inside registerUser()");
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User authenticateUser(User user) {
		logger.info("Inside authenticateUser()");
		Query query = query = sessionFactory.getCurrentSession().createQuery("select u from User u");
		List<User> petList = (List<User>)query.list();
		return petList.stream()
				.filter(userDB -> userDB != null && 
				userDB.getUserName().equals(user.getUserName()) && 
				userDB.getUserPassword().equals(user.getUserPassword())).findAny().orElse(null);
		 
	
	}

	@Override
	public Set<Pet> getMyPetsById(Long userId) {
		logger.info("Inside getMyPetsById()");
		User fetchUserById = (User) sessionFactory.getCurrentSession().get(User.class, userId);
		
		Set<Pet> pets = fetchUserById.getPets();
		 if(pets!= null && !pets.isEmpty()) {
			 return pets;
		 }
		return new HashSet<>();
	}

	@Override
	public boolean userAuthentication(User user) {
		logger.info("Inside userAuthentication()");
		Query query=sessionFactory.getCurrentSession().createQuery("select u from User u");
		List<User> userList = (List<User>)query.list();
		 if(userList.stream().filter(userdb -> userdb !=null && userdb.getUserName().equals(user.getUserName())).findAny().orElse(null) != null){
			 return true;
		 }
		 else {
			 return false;
		 }
				 
	}
}
