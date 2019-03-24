package com.fahimsoft.demo2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahimsoft.demo2.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

	List<User> findByNameLike(String name);

}
