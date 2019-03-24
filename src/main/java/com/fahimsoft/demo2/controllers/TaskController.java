package com.fahimsoft.demo2.controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fahimsoft.demo2.entities.Task;
import com.fahimsoft.demo2.services.TaskService;
import com.fahimsoft.demo2.services.UserService;

@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/addTask", method=RequestMethod.GET)
	public String taskForm(String email, Model model, HttpSession session) {
		 
		 session.setAttribute("email", email); 
		 model.addAttribute("task", new Task());
		 return "view/taskForm";
		 
	 }
	
	@RequestMapping(value="/addTask", method=RequestMethod.POST)
	public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session) throws IOException{
		if(bindingResult.hasErrors()) {
			return "views/taskForm";
		}
		String email = (String) session.getAttribute("email");
		taskService.addTask(task, userService.findOne(email));
		return "redirect:/users";
	}

}
