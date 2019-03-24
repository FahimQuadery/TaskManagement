package com.fahimsoft.demo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fahimsoft.demo2.services.UserService;

@Controller
public class UserController {

	@Autowired 
	private UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String listUsers(Model model, @RequestParam(defaultValue="") String name) {
		model.addAttribute("users", userService.findByName(name));
		return "view/list";
	}
}
