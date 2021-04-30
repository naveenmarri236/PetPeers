package com.hcl.cs.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.hcl.cs.model.Pet;
import com.hcl.cs.model.User;
import com.hcl.cs.service.PetService;
import com.hcl.cs.service.UserService;

@Controller
public class MainController {

	Logger logger=Logger.getLogger(MainController.class);
	
	@Autowired
	private PetService petService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public ModelAndView index() {
		logger.info("Inside index()");
		ModelAndView modelAndView = new ModelAndView("registration");
		modelAndView.addObject("user", new User());
		return modelAndView;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, @ModelAttribute("user") User user) {
		logger.info("Inside login()");
		User authenticateUser = userService.authenticateUser(user);

		System.out.println(authenticateUser);
		if (authenticateUser == null) {			
			ModelAndView modelAndView = new ModelAndView("login");
			modelAndView.addObject("login", new User());
			return modelAndView;
		} else {

			request.getSession().setAttribute("user", authenticateUser.getUserId());
			ModelAndView modelAndView = new ModelAndView("home");
			modelAndView.addObject("pets", petService.getAllPets());
			return modelAndView;
		}
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView registerSuccess(@Validated @ModelAttribute("user") User user, BindingResult result) {
		logger.info("Inside registerSuccess()");
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("registration");
			return modelAndView;
		} else {
			System.out.println("=====>");
			boolean userAuthentication = userService.userAuthentication(user);
			if(user.getUserPassword().equals(user.getConfirmPassword())) {
				if (userAuthentication) {
					ModelAndView modelAndView = new ModelAndView("registration");
					System.out.println("already exit user=====>");
					return modelAndView;
				} 
				else {
					System.out.println("SuccessfullyRegistered=====>");
					ModelAndView modelAndView = new ModelAndView("login");
					userService.saveUser(user);
					modelAndView.addObject("user", new User());
					return modelAndView;
				}
			}
			else {
				ModelAndView modelAndView = new ModelAndView("registration");
				System.out.println("Password does not match userpassword=====>");
				return modelAndView;
			}
		}

	}

	@RequestMapping(value = "/loginuser", method = RequestMethod.GET)
	public ModelAndView loginUser() {
		logger.info("Inside loginUser()");
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("user", new User());
		return modelAndView;

	}

	@RequestMapping(value = "/home")
	public ModelAndView home(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		logger.info("Inside home()");
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("pets", petService.getAllPets());
		return modelAndView;
	}

	@RequestMapping(value = "/savePet", method = RequestMethod.POST)
	public ModelAndView savePet(@Validated @ModelAttribute("pet") Pet pet, BindingResult result) {
		logger.info("Inside savePet()");
		System.out.print("pet  " + pet);
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("addPet");
			modelAndView.addObject("addPet", new Pet());
			return modelAndView;
		} else {
			petService.addPet(pet);
			List<Pet> pets = petService.getAllPets();
			ModelAndView modelAndView = new ModelAndView("home");
			modelAndView.addObject("pets", pets);

			return modelAndView;
		}

	}

	@RequestMapping(value = "/addPet", method = RequestMethod.GET)
	public ModelAndView addPet() {
		logger.info("Inside addPet()");
		System.out.println("addPet method");
		ModelAndView modelAndView = new ModelAndView("addPet");
		modelAndView.addObject("addPet", new Pet());

		return modelAndView;

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView petList(HttpServletRequest request) {
		logger.info("Inside petList()");
		List<Pet> pets = petService.getAllPets();
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("pets", pets);

		return modelAndView;
	}

	@RequestMapping(value = "/buyPet/{id}", method = RequestMethod.GET)
	public ModelAndView buyPet(@Validated @PathVariable("id") Long petId, HttpServletRequest request) {
		logger.info("Inside buyPet()");
		Long userId = (Long) request.getSession().getAttribute("user");

		System.out.println(userId);

		Pet pet = petService.getPetByPetId(petId);

		userService.buyPet(userId, pet);

		Set<Pet> petById = userService.getPetById(userId);
		ModelAndView modelAndView = new ModelAndView("myPets");
		modelAndView.addObject("pets", petById);

		return modelAndView;

	}

	@RequestMapping(value = "/myPets", method = RequestMethod.GET)
	public ModelAndView myPets(HttpServletRequest request) {
		logger.info("Inside myPets()");
		Long userId = (Long) request.getSession().getAttribute("user");

		Set<Pet> petById = userService.getPetById(userId);
		ModelAndView modelAndView = new ModelAndView("myPets");
		modelAndView.addObject("pets", petById);
		return modelAndView;

	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		logger.info("Inside logout()");
		ModelAndView modelAndView = new ModelAndView("registration");
		modelAndView.addObject("user", new User());
		return modelAndView;

	}

}
