package com.tech.blog.auth;

import com.tech.blog.user.Role;
import com.tech.blog.user.User;
import com.tech.blog.user.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final UserServiceImpl userService;

    public boolean login(ResponseRequest request) {
        return userService.login(request.getEmail(), request.getPassword());
    }

    public boolean logout(DeAuthenticationRequest request) {
        return userService.logout(request.getId());
    }

    public boolean register(ResponseRequest request) {
        User user = new User(false, request.getEmail(), request.getPassword(), Role.USER);
        return userService.register(user);
    }

}
