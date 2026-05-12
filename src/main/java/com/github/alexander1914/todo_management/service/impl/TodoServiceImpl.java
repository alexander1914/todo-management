package com.github.alexander1914.todo_management.service.impl;

import com.github.alexander1914.todo_management.dto.TodoDto;
import com.github.alexander1914.todo_management.entity.Todo;
import com.github.alexander1914.todo_management.exception.ResourceNotFoundException;
import com.github.alexander1914.todo_management.repository.TodoRepository;
import com.github.alexander1914.todo_management.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        // Convert TodoDto int TODO JPA Entity
        Todo todo = modelMapper.map(todoDto, Todo.class);

        // Todo Jpa entity
        Todo savedTodo = todoRepository.save(todo);

        // Convert saved TODO JPA entity object into TodoDto object
        TodoDto savedTodoDto = modelMapper.map(todo, TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TODO not found with id:" + id));

        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }
}
