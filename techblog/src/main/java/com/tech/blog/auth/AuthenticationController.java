package com.tech.blog.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody ResponseRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PutMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody ResponseRequest request){
        return ResponseEntity.ok(service.login(request));
    }

    @PutMapping("/logout")
    public ResponseEntity<Boolean> logout(@RequestBody DeAuthenticationRequest request){
        System.out.println(request.getId());
        return ResponseEntity.ok(service.logout(request));
    }
}
