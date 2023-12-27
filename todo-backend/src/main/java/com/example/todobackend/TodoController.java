package com.example.todobackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok().body(todos);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Todo> getTodoByName(@PathVariable String name) {
        Todo todo = todoService.getTodoByName(name);
        return todo != null ? ResponseEntity.ok().body(todo) : ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteTodoByName(@PathVariable String name) {
        boolean deleted = todoService.deleteTodoByName(name);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/")
    public ResponseEntity<Todo> updateTodoPriority(@RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodoPriority(todo);
        return updatedTodo != null ? ResponseEntity.ok().body(updatedTodo) : ResponseEntity.notFound().build();
    }
}