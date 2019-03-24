package com.fahimsoft.demo2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fahimsoft.demo2.entities.Task;
import com.fahimsoft.demo2.entities.User;
import com.fahimsoft.demo2.services.TaskService;
import com.fahimsoft.demo2.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {

	@Autowired 
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@Before
	public void initDb() throws IOException {
		User newUser = User.builder().email("testUser@email.com").name("testUser").password("123456").build();
		userService.createUser(newUser);
		
		User newAdmin = User.builder().email("testAdmin@email.com").name("testAdmin").password("123456").build();
		userService.createAdmin(newAdmin);
		
		Task userTask = Task.builder().date("24/02/2019").
								startTime("10:11").
								stopTime("12:30").
								description("Task to complete.")
								.build();
		User user = userService.findOne("testUser@email.com");
		taskService.addTask(userTask, user);
	}
	
	@Test
	public void testUser() {
		try{
			User user = userService.findOne("testUser@email.com");
			assertNotNull(user);
			User admin = userService.findOne("testAdmin@email.com");
			assertEquals(admin.getEmail(), "testAdmin@email.com");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("User not found");
		}
		
	}
	
	@Test
	public void testTask() {
		try {
			User user = userService.findOne("testUser@email.com");
			List<Task> tasks = taskService.findUserTask(user);
			assertNotNull(tasks);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
