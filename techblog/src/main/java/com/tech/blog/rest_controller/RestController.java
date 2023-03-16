package com.tech.blog.rest_controller;

import com.tech.blog.request_respone.UserDeleteRequest;
import com.tech.blog.request_respone.UserIdRequest;
import com.tech.blog.request_respone.RegAuthRequest;
import com.tech.blog.user.Role;
import com.tech.blog.user.User;
import com.tech.blog.user.UserServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RestController {
    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody RegAuthRequest request){
        User user = new User(false, request.getEmail(), request.getPassword(), Role.USER);
        return ResponseEntity.ok(userService.register(user));
    }

    @PutMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody RegAuthRequest request){
        return ResponseEntity.ok(userService.login(request.getEmail(), request.getPassword()));
    }

    @PutMapping("/logout")
    public ResponseEntity<Boolean> logout(@RequestBody UserIdRequest request){
        return ResponseEntity.ok(userService.logout(request.getId()));
    }

    @DeleteMapping("/delete_user")
    public ResponseEntity<Boolean> removeUser(@RequestBody UserDeleteRequest request){
        return ResponseEntity.ok(userService.deleteUser(request.getId(), request.getIdAdminUser()));
    }

    @GetMapping("/user_data/{user_id}")
    @ResponseBody
    public User dataUser(@PathVariable Integer user_id){
        return userService.getUserById(user_id);
    }
}
