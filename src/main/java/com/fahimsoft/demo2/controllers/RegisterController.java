package com.fahimsoft.demo2.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fahimsoft.demo2.entities.User;
import com.fahimsoft.demo2.services.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "view/registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "view/registerForm";
		}
		
		if(userService.isUserPresent(user.getEmail())) {
			model.addAttribute("exist", true);
			return "view/registerForm";
		}
		
		userService.createUser(user);
		return "view/success";

	}

}
