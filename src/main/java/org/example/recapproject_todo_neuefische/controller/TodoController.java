package org.example.recapproject_todo_neuefische.controller;

import org.example.recapproject_todo_neuefische.dto.RegisterTodoDTO;
import org.example.recapproject_todo_neuefische.entity.Todo;
import org.example.recapproject_todo_neuefische.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //GET Mapping
    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.findAll();
    }

    //Post Mapping
    @PostMapping
    public void addTodo(@RequestBody RegisterTodoDTO newUser){
        todoService.createNewTodo(newUser);
    }
}
