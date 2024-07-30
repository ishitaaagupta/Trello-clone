package com.trelloclone.Controller;


import com.trelloclone.Configuration.JwtUtil;
import com.trelloclone.Model.LoginRequest;
import com.trelloclone.Model.User;
import com.trelloclone.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        if (userService.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("User is already registered");
        }
        userService.save(user);
        return ResponseEntity.ok("User registration successful");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        User existingUser = userService.findByEmail(loginRequest.getEmail());
        if (existingUser != null && passwordEncoder.matches(loginRequest.getPassword(), existingUser.getPassword())) {
            String token = jwtUtil.generateToken(new org.springframework.security.core.userdetails.User(
                    existingUser.getEmail(), existingUser.getPassword(), Collections.emptyList()));
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("token", token);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}


