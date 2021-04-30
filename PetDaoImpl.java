package com.hcl.cs.dao;

import java.util.ArrayList;
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
public class PetDaoImpl implements PetDao {

	Logger logger=Logger.getLogger(PetDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Pet> getAllPets() {
		logger.info("Inside getAllPets()");
		Query query = query = sessionFactory.openSession().createQuery("select p from Pet p");
		List<Pet> petList = (List<Pet>) query.list();
		Set<Pet> userPets = new HashSet<Pet>();
		if (petList != null && !petList.isEmpty()) {

			Query query1 = sessionFactory.openSession().createQuery("select u from User u");

			List<User> users = (List<User>) query1.list();
			System.out.println("-------------->> " + petList);
			System.out.println("-------------->> " + users);

			petList.forEach(pet -> {
				users.forEach(user -> {

					userPets.addAll(user.getPets());

				});

			});

			petList.forEach(pets -> {
				pets.setBuy(userPets.stream().anyMatch(userPet -> userPet.getPetId().equals(pets.getPetId())));
			});

			System.out.print(petList);
			return petList;
		}
		return new ArrayList<Pet>();
	}

	@Override
	public void addPet(Pet pet) {
		logger.info("Inside addPet()");
		sessionFactory.getCurrentSession().save(pet);

	}

	@Override
	public Pet getPetByPetId(Long petId) {
		logger.info("Inside getPetByPetId()");
		Pet pet = (Pet) sessionFactory.getCurrentSession().get(Pet.class, petId);
		return pet;
	}

}
