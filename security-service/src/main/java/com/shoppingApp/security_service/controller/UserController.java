package com.shoppingApp.security_service.controller;

import com.shoppingApp.security_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        String token = userService.login(username, password);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        String role = request.get("role");
        userService.register(username, password, role);
        return ResponseEntity.ok(Map.of("message", "User registered successfully"));
    }
}
