package com.tech.blog;

import com.tech.blog.dao.AdditionalUserDataRepository;
import com.tech.blog.dao.UserRepository;
import com.tech.blog.dao.UserRepositoryDisplay;
import com.tech.blog.service.user.AppNewsObservable;
import com.tech.blog.service.user.UserServiceImpl;
import com.tech.blog.user.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class BlogApplicationTestsAppNewsObserver {
    @Mock
    private UserRepository userRepository;

    @Mock
    private AdditionalUserDataRepository additionalUserDataRepository;

    @Mock
    private UserRepositoryDisplay userRepositoryDisplay;

    @Test
    void testAppNewsObservableSetNewUpdate(){
        AppNewsObservable appNewsObservable = new UserServiceImpl(userRepository, additionalUserDataRepository, userRepositoryDisplay);
        List<User> appNewsObservableUsers = new LinkedList<>();
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        doNothing().when(user1).notify("title", "newUpdate");
        doNothing().when(user2).notify("title", "newUpdate");
        appNewsObservableUsers.add(user1);
        appNewsObservableUsers.add(user2);
        when(userRepository.findAll()).thenReturn(appNewsObservableUsers);
        appNewsObservable.setNewUpdate("title", "newUpdate");
        verify(userRepository).findAll();
        verify(user1).notify("title", "newUpdate");
        verify(user2).notify("title", "newUpdate");
    }
}
