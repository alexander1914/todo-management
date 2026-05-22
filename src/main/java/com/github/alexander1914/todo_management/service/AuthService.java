package com.github.alexander1914.todo_management.service;

import com.github.alexander1914.todo_management.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto  registerDto);
}
