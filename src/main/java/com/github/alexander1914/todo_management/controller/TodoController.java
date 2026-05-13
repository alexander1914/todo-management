package com.github.alexander1914.todo_management.controller;

import com.github.alexander1914.todo_management.dto.TodoDto;
import com.github.alexander1914.todo_management.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // Build Add ToDo REST API
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {

        TodoDto savedTodo = todoService.addTodo(todoDto);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    //Build GET ToDo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId) {

        TodoDto todoDto = todoService.getTodo(todoId);

        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    //Build GET All ToDo REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {

        List<TodoDto> todos = todoService.getAllTodos();

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    //Build Update ToDo REST API
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId) {

        TodoDto updatedTodo = todoService.updateTodo(todoDto, todoId);

        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    //Build Delete ToDo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {

        todoService.deleteTodo(todoId);

        return new ResponseEntity<>("Todo deleted successfully", HttpStatus.OK);
    }

    //Build Completed ToDo REST API
    @PatchMapping("{id}/completed")
    public ResponseEntity<TodoDto> completedTodo(@PathVariable("id") Long todoId) {

        TodoDto updatedTodo = todoService.completedTodo(todoId);

        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    //Build Incompleted ToDo REST API
    @PatchMapping("{id}/incompleted")
    public ResponseEntity<TodoDto> inCompletedTodo(@PathVariable("id") Long todoId) {

        TodoDto updatedTodo = todoService.inCompletedTodo(todoId);

        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }
}
