package com.fahimsoft.demo2.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fahimsoft.demo2.entities.User;
import com.fahimsoft.demo2.services.TaskService;
import com.fahimsoft.demo2.services.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	

	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal) {
		
		String email = principal.getName();
		User user = null;
		try{
			user = userService.findOne(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("tasks", taskService.findUserTask(user));
		
		
		return "view/profile";
	}
}
