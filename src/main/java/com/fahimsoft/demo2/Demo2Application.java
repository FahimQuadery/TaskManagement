package com.fahimsoft.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fahimsoft.demo2.entities.User;
import com.fahimsoft.demo2.services.UserService;

@SpringBootApplication
public class Demo2Application implements  CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		  {
    		  User newAdmin =  User.builder().email("dmin@mail.com").name("Admin").password("123456").build() ; 
    		  userService.createAdmin(newAdmin); 
    	  }
	}

}
