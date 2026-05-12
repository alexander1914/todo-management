package com.github.alexander1914.todo_management.service;

import com.github.alexander1914.todo_management.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);
    TodoDto getTodo(Long id);
    List<TodoDto> getAllTodos();
}
