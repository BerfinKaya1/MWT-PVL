package com.example.todobackend;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        Iterable<Todo> todosIterable = todoRepository.findAll();
        List<Todo> todosList = new ArrayList<>();
        todosIterable.forEach(todosList::add);
        return todosList;
    }

    public Todo getTodoByName(String name) {
        return todoRepository.findByName(name);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public boolean deleteTodoByName(String name) {
        Todo todo = todoRepository.findByName(name);
        if (todo != null) {
            todoRepository.delete(todo);
            return true;
        }
        return false;
    }

    public Todo updateTodoPriority(Todo todo) {
        Todo existingTodo = todoRepository.findByName(todo.getName());
        if (existingTodo != null) {
            existingTodo.setPriority(todo.getPriority());
            return todoRepository.save(existingTodo);
        }
        return null;
    }
}
