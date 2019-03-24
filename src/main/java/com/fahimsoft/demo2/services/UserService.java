package com.fahimsoft.demo2.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fahimsoft.demo2.entities.Role;
import com.fahimsoft.demo2.entities.User;
import com.fahimsoft.demo2.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = Role.builder().name("USER").build();
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	public void createAdmin(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = Role.builder().name("ADMIN").build();
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	public User findOne(String email) throws IOException {
		Optional<User> optional = userRepository.findById(email);
		if(optional.isPresent()) {
			return optional.get();
		}
		return optional.orElse(null);
	}

	public boolean isUserPresent(String email) {
		// TODO Auto-generated method stub
		return userRepository.findById(email).isPresent();
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByNameLike("%"+name+"%");
	}
}
