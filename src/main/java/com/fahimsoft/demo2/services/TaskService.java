package com.fahimsoft.demo2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahimsoft.demo2.entities.Task;
import com.fahimsoft.demo2.entities.User;
import com.fahimsoft.demo2.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepository.save(task);
	}
	
	public List<Task> findUserTask(User user) {
		return taskRepository.findByUser(user);
	}
}
