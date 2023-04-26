package com.tech.blog;

import com.tech.blog.dao.AdditionalUserDataRepository;
import com.tech.blog.dao.UserRepository;
import com.tech.blog.service.user.UserService;
import com.tech.blog.service.user.UserServiceImpl;
import com.tech.blog.user.Role;
import com.tech.blog.user.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class BlogApplicationTests {

	@Mock
	private UserRepository userRepository;

	@Mock
	private AdditionalUserDataRepository additionalUserDataRepository;

	@Test
	void testUserServiceGetUserById(){
		User user = new User(true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
		when(userRepository.findById(1)).thenReturn(Optional.of(user));
		User test_user = userService.getUserById(1);
		assertTrue(test_user.getIdUser() == user.getIdUser());
		verify(userRepository).findById(1);
	}

	@Test
	void testUserServiceLoggedIn(){
		User user = new User(false, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
		when(userRepository.findByEmailAndPassword("test@mock.com", "1234")).thenReturn(Optional.of(user));
		boolean log_in_user = userService.login("test@mock.com", "1234");
		assertTrue(log_in_user == true);
		verify(userRepository).findByEmailAndPassword("test@mock.com", "1234");
		verify(userRepository).save(user);
	}

	@Test
	void testUserServiceAlreadyLoggedIn(){
		User user = new User(true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
		when(userRepository.findByEmailAndPassword("test@mock.com", "1234")).thenReturn(Optional.of(user));
		boolean log_in_user = userService.login("test@mock.com", "1234");
		assertTrue(log_in_user == false);
		verify(userRepository).findByEmailAndPassword("test@mock.com", "1234");
	}

	@Test
	void testUserServiceNullUserLoggedIn(){
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
		when(userRepository.findByEmailAndPassword("test@mock.com", "1234")).thenReturn(null);
		boolean log_in_user = userService.login("test@mock.com", "1234");
		assertTrue(log_in_user == false);
		verify(userRepository).findByEmailAndPassword("test@mock.com", "1234");
	}


	@Test
	void testUserServiceLogOut(){
		User user = new User(true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);

	}

	@Test
	void testUserServiceRegister(){
		User user = new User(true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);

	}

	@Test
	void testUserServiceGetUserByEmail(){
		User user = new User(true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);

	}

	@Test
	void testUserServiceGetAllUsers(){
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);

	}

	@Test
	void testUserServiceDeleteUser(){
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);

	}

	@Test
	void testUserServiceUpdateUserData(){
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);

	}

	@Test
	void testAppNewsObservableSetNewUpdate(){
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);

	}


}
