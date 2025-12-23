package com.todo.app.todo_application.services;

import com.todo.app.todo_application.model.Todo;
import com.todo.app.todo_application.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    public List<Todo> getAllTodo(){
        return todoRepo.findAll();
    }

    public Todo saveTodo(Todo todo){
        return todoRepo.save(todo);
    }


    public void deleteTodo(Long id) {
        todoRepo.deleteById(id);
    }

    public Optional<Todo> updateTodo(Long id , Todo todo) {

        Optional<Todo> newTodo = Optional.of(todoRepo.save(todo));


        return newTodo;

    }
}
