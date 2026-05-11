package com.github.alexander1914.todo_management.repository;

import com.github.alexander1914.todo_management.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
