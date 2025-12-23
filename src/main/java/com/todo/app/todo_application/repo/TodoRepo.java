package com.todo.app.todo_application.repo;

import com.todo.app.todo_application.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {

}
