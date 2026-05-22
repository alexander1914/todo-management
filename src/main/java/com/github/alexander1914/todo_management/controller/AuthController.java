package com.github.alexander1914.todo_management.controller;

import com.github.alexander1914.todo_management.dto.RegisterDto;
import com.github.alexander1914.todo_management.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    //Build Register REST API
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);

        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }
}
