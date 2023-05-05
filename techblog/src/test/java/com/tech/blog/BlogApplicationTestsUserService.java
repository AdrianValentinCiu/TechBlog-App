package com.tech.blog;

import com.tech.blog.dao.AdditionalUserDataRepository;
import com.tech.blog.dao.UserRepository;
import com.tech.blog.service.user.AppNewsObservable;
import com.tech.blog.service.user.UserService;
import com.tech.blog.service.user.UserServiceImpl;
import com.tech.blog.user.AdditionalUserData;
import com.tech.blog.user.AppNewsObserver;
import com.tech.blog.user.Role;
import com.tech.blog.user.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class BlogApplicationTestsUserService {

	@Mock
	private UserRepository userRepository;

	@Mock
	private AdditionalUserDataRepository additionalUserDataRepository;

//	@Test
//	void testUserServiceGetUserByIdFound(){
//		User user = new User(true, "test@mock.com", "1234", Role.USER);
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		when(userRepository.findById(1)).thenReturn(Optional.of(user));
//		User test_user = userService.getUserById(1);
//		assertTrue(test_user.getIdUser() == user.getIdUser());
//		verify(userRepository).findById(1);
//	}
//
//	@Test
//	void testUserServiceGetUserByIdNotFound(){
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		User test_user = userService.getUserById(100);
//		assertTrue(test_user == null);
//		verify(userRepository).findById(100);
//	}
//
//	@Test
//	void testUserServiceLoggedIn(){
//		User user = new User(false, "test@mock.com", "1234", Role.USER);
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		when(userRepository.findByEmailAndPassword("test@mock.com", "1234")).thenReturn(Optional.of(user));
//		boolean log_in_user = userService.login("test@mock.com", "1234");
//		assertTrue(log_in_user == true);
//		verify(userRepository).findByEmailAndPassword("test@mock.com", "1234");
//		verify(userRepository).save(user);
//	}
//
//	@Test
//	void testUserServiceAlreadyLoggedIn(){
//		User user = new User(true, "test@mock.com", "1234", Role.USER);
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		when(userRepository.findByEmailAndPassword("test@mock.com", "1234")).thenReturn(Optional.of(user));
//		boolean log_in_user = userService.login("test@mock.com", "1234");
//		assertTrue(log_in_user == false);
//		verify(userRepository).findByEmailAndPassword("test@mock.com", "1234");
//	}
//
//	@Test
//	void testUserServiceNullUserLoggedIn(){
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		when(userRepository.findByEmailAndPassword("test@mock.com", "1234")).thenReturn(null);
//		boolean log_in_user = userService.login("test@mock.com", "1234");
//		assertTrue(log_in_user == false);
//		verify(userRepository).findByEmailAndPassword("test@mock.com", "1234");
//	}
//
//
//	@Test
//	void testUserServiceLogOut(){
//		User user = new User(true, "test@mock.com", "1234", Role.USER);
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		when(userRepository.findById(1)).thenReturn(Optional.of(user));
//		boolean log_out_user = userService.logout(1);
//		assertTrue(log_out_user == true);
//		verify(userRepository).findById(1);
//		verify(userRepository).save(user);
//	}
//
//	@Test
//	void testUserServiceNullLogOut(){
//		User user = new User(false, "test@mock.com", "1234", Role.USER);
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
//		boolean log_out_user = userService.logout(100);
//		assertTrue(log_out_user == false);
//		verify(userRepository).findById(100);
//	}
//
//	@Test
//	void testUserServiceRegister(){
//		User user = new User(5,true, "test@mock.com", "1234", Role.USER);
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		boolean register_user = userService.register(user);
//		assertTrue(register_user == true);
//		verify(userRepository).save(user);
//		verify(userRepository).findByEmail(user.getEmail());
//	}
//
//	@Test
//	void testUserServiceAlreadyRegistered(){
//		User user = new User(5,true, "test@mock.com", "1234", Role.USER);
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
//		boolean register_user = userService.register(user);
//		assertTrue(register_user == false);
//		verify(userRepository).findByEmail(user.getEmail());
//	}
//
//	@Test
//	void testUserServiceGetUserByEmail(){
//		User user = new User(5, true, "test@mock.com", "1234", Role.USER);
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
//		assertTrue(userService.getUserByEmail(user.getEmail()) == user);
//		verify(userRepository).findByEmail(user.getEmail());
//	}
//
//	@Test
//	void testUserServiceDeleteUser(){
//		User user_admin = new User(1, true, "test@mock.com", "1234", Role.ADMIN);
//		User user_del = new User(2, true, "test@mock.com", "1234", Role.USER);
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		when(userRepository.findById(user_del.getIdUser())).thenReturn(Optional.of(user_del));
//		when(userRepository.findById(user_admin.getIdUser())).thenReturn(Optional.of(user_admin));
//		assertTrue(userService.deleteUser(user_del.getIdUser(), user_admin.getIdUser()) == true);
//		verify(userRepository).deleteById(user_del.getIdUser());
//	}
//
//	@Test
//	void testUserServiceDeleteNotFoundUser(){
//		User user_admin = new User(1, true, "test@mock.com", "1234", Role.ADMIN);
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		when(userRepository.findById(user_admin.getIdUser())).thenReturn(Optional.of(user_admin));
//		assertTrue(userService.deleteUser(1, user_admin.getIdUser()) == false);
//	}
//
//	@Test
//	void testUserServiceDeleteNotAnAdminUser(){
//		User user_admin = new User(1, true, "test@mock.com", "1234", Role.USER);
//		User user_del = new User(2, true, "test@mock.com", "1234", Role.USER);
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		when(userRepository.findById(user_del.getIdUser())).thenReturn(Optional.of(user_del));
//		when(userRepository.findById(user_admin.getIdUser())).thenReturn(Optional.of(user_admin));
//		assertTrue(userService.deleteUser(user_del.getIdUser(), user_admin.getIdUser()) == false);
//	}
//
//	@Test
//	void testUserServiceDeleteAdminNotFoundUser(){
//		User user_del = new User(2, true, "test@mock.com", "1234", Role.USER);
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		when(userRepository.findById(user_del.getIdUser())).thenReturn(Optional.of(user_del));
//		assertTrue(userService.deleteUser(user_del.getIdUser(), 1) == false);
//	}
//
//	@Test
//	void testUserServiceUpdateUserData(){
//		User user = new User(5, true, "test@mock.com", "1234", Role.USER);
//		AdditionalUserData additionalUserData = new AdditionalUserData(user.getIdUser(), "Test", "Mock", "new test");
//		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
//		assertTrue(userService.updateUserData(user.getIdUser(), "Test", "Mock", "new test") == true);
//		verify(additionalUserDataRepository).save(additionalUserData);
//	}

}
