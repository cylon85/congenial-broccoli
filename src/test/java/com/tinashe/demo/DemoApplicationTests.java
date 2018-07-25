package com.tinashe.demo;

import com.tinashe.demo.dao.TaskRepository;
import com.tinashe.demo.dao.UserRepository;
import com.tinashe.demo.entity.User;
import com.tinashe.demo.manager.UserManager;
import com.tinashe.demo.rest.V1Controller;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {
	@Autowired
	TaskRepository taskRepository;

	@Autowired
	UserRepository userRepository;

	UserManager userManagerMock;

	@Autowired
	V1Controller v1Controller;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.standaloneSetup(v1Controller).build();

		userManagerMock = new UserManager() {

			@Override
			public User getUserInformation(Long id) {
				return null;
			}

			@Override
			public List<User> findAllUsers() {
				List<User> list = new ArrayList<>();
	//			list.add(UserUtils.getUserResponse());
				return list;
			}

			@Override
			public Void createUser(User user) {
				return null;
			}

			@Override
			public Void updateUser(User user) {
				return null;
			}


		};

	}

	@Test
	public void contextLoads() {
	}

}
