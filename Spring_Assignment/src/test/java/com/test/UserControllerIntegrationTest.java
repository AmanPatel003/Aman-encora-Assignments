package com.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.controller.UserController;
import com.model.User;
import com.repo.UserRepository;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private UserRepository userRepository;
	
	@BeforeEach
	void setup() {
		userRepository.save(new User(1L,"Alice"));
	}
	
	@Test
	void shouldReturnUserFromDatabase() throws Exception{
		mockMvc.perform(get("/users/1")).andExpect(status().isOk())
		.andExpect(jsonPath("$.uname").value("Alice"));
	}
	
	@Test
	void shouldReturnNotFoundForMissingUser() throws Exception{
		mockMvc.perform(get("/users/99"))
		.andExpect(status().isNotFound());
	}

}
