package com.todo.app.todo_application.controller;

import com.todo.app.todo_application.model.Todo;
import com.todo.app.todo_application.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/get")
    public ResponseEntity<?> getAllTodo(){
        List<Todo> allTodo = todoService.getAllTodo();
        return new ResponseEntity<>(allTodo , HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveTodo(@RequestBody Todo todo){
        todoService.saveTodo(todo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public Optional<Todo> updateTodo(@PathVariable Long id , @RequestBody Todo todo){
        return todoService.updateTodo(id , todo);
    }
}
