package com.fahimsoft.demo2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahimsoft.demo2.entities.Task;
import com.fahimsoft.demo2.entities.User;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user);

}
