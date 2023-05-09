package com.tech.blog;

import com.tech.blog.Dao.AdditionalUserDataRepository;
import com.tech.blog.Dao.UserRepository;
import com.tech.blog.Dao.UserRepositoryDisplay;
import com.tech.blog.Service.User.UserService;
import com.tech.blog.Service.User.UserServiceImpl;
import com.tech.blog.User.AdditionalUserData;
import com.tech.blog.User.Role;
import com.tech.blog.User.User;
import com.tech.blog.User.UserDisplay;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class BlogApplicationTestsUserService {

	@Mock
	private UserRepository userRepository;

	@Mock
	private AdditionalUserDataRepository additionalUserDataRepository;

	@Mock
	private UserRepositoryDisplay userRepositoryDisplay;

	@Test
	void testUserServiceGetUserByIdFound(){
		UserDisplay user = new UserDisplay(1, true, "test@mock.com", "1234", Role.USER, "Adi", "Student");
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepositoryDisplay.findUserById(1)).thenReturn(Optional.of(user));
		UserDisplay test_user = userService.getUserById(1);
		assertTrue(test_user.getIdUser() == user.getIdUser());
		verify(userRepositoryDisplay).findUserById(1);
	}

	@Test
	void testUserServiceGetUserByIdNotFound(){
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		UserDisplay test_user = userService.getUserById(100);
		assertTrue(test_user == null);
		verify(userRepositoryDisplay).findUserById(100);
	}

	@Test
	void testUserServiceLoggedIn(){
		User user = new User(false, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepository.findByEmailAndPassword("test@mock.com", "1234")).thenReturn(Optional.of(user));
		boolean log_in_user = userService.login("test@mock.com", "1234");
		assertTrue(log_in_user == true);
		verify(userRepository).findByEmailAndPassword("test@mock.com", "1234");
		verify(userRepository).save(user);
	}

	@Test
	void testUserServiceAlreadyLoggedIn(){
		User user = new User(true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepository.findByEmailAndPassword("test@mock.com", "1234")).thenReturn(Optional.of(user));
		boolean log_in_user = userService.login("test@mock.com", "1234");
		assertTrue(log_in_user == false);
		verify(userRepository).findByEmailAndPassword("test@mock.com", "1234");
	}

	@Test
	void testUserServiceNullUserLoggedIn(){
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepository.findByEmailAndPassword("test@mock.com", "1234")).thenReturn(null);
		boolean log_in_user = userService.login("test@mock.com", "1234");
		assertTrue(log_in_user == false);
		verify(userRepository).findByEmailAndPassword("test@mock.com", "1234");
	}


	@Test
	void testUserServiceLogOut(){
		User user = new User(true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepository.findById(1)).thenReturn(Optional.of(user));
		boolean log_out_user = userService.logout(1);
		assertTrue(log_out_user == true);
		verify(userRepository).findById(1);
		verify(userRepository).save(user);
	}

	@Test
	void testUserServiceNullLogOut(){
		User user = new User(false, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
		boolean log_out_user = userService.logout(100);
		assertTrue(log_out_user == false);
		verify(userRepository).findById(100);
	}

	@Test
	void testUserServiceRegister(){
		User user = new User(5,true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		boolean register_user = userService.register(user);
		assertTrue(register_user == true);
		verify(userRepository).save(user);
		verify(userRepository).findByEmail(user.getEmail());
	}

	@Test
	void testUserServiceAlreadyRegistered(){
		User user = new User(5,true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
		boolean register_user = userService.register(user);
		assertTrue(register_user == false);
		verify(userRepository).findByEmail(user.getEmail());
	}

	@Test
	void testUserServiceGetUserByEmail(){
		User user = new User(5, true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
		assertTrue(userService.getUserByEmail(user.getEmail()) == user);
		verify(userRepository).findByEmail(user.getEmail());
	}

	@Test
	void testUserServiceDeleteUser(){
		User user_admin = new User(1, true, "test@mock.com", "1234", Role.ADMIN);
		User user_del = new User(2, true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepository.findById(user_del.getIdUser())).thenReturn(Optional.of(user_del));
		when(userRepository.findById(user_admin.getIdUser())).thenReturn(Optional.of(user_admin));
		assertTrue(userService.deleteUser(user_del.getIdUser(), user_admin.getIdUser()) == true);
		verify(userRepository).deleteById(user_del.getIdUser());
	}

	@Test
	void testUserServiceDeleteNotFoundUser(){
		User user_admin = new User(1, true, "test@mock.com", "1234", Role.ADMIN);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepository.findById(user_admin.getIdUser())).thenReturn(Optional.of(user_admin));
		assertTrue(userService.deleteUser(1, user_admin.getIdUser()) == false);
	}

	@Test
	void testUserServiceDeleteNotAnAdminUser(){
		User user_admin = new User(1, true, "test@mock.com", "1234", Role.USER);
		User user_del = new User(2, true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepository.findById(user_del.getIdUser())).thenReturn(Optional.of(user_del));
		when(userRepository.findById(user_admin.getIdUser())).thenReturn(Optional.of(user_admin));
		assertTrue(userService.deleteUser(user_del.getIdUser(), user_admin.getIdUser()) == false);
	}

	@Test
	void testUserServiceDeleteAdminNotFoundUser(){
		User user_del = new User(2, true, "test@mock.com", "1234", Role.USER);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepository.findById(user_del.getIdUser())).thenReturn(Optional.of(user_del));
		assertTrue(userService.deleteUser(user_del.getIdUser(), 1) == false);
	}

	@Test
	void testUserServiceUpdateUserData(){
		User user = new User(5, true, "test@mock.com", "1234", Role.USER);
		AdditionalUserData additionalUserData = new AdditionalUserData(user.getIdUser(), "Test", "Mock", "new test");
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		assertTrue(userService.updateUserData(user.getIdUser(), "Test", "Mock", "new test") == true);
		verify(additionalUserDataRepository).save(additionalUserData);
	}

	@Test
	void testUserServiceGetAllUsers(){
		User user1 = new User(5, true, "test1@mock.com", "1234", Role.USER);
		User user2 = new User(5, true, "test2@mock.com", "1234", Role.USER);
		User user3 = new User(5, true, "test3@mock.com", "1234", Role.USER);
		List<User> users = new LinkedList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
		when(userRepository.findAll()).thenReturn(users);
		List<User> testUsers = userService.getAllUsers();
		assertTrue(testUsers == users);
		verify(userRepository).findAll();
	}

}
