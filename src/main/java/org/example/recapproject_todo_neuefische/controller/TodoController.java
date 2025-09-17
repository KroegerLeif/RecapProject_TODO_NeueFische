package org.example.recapproject_todo_neuefische.controller;

import org.example.recapproject_todo_neuefische.dto.ChangeTodoDTO;
import org.example.recapproject_todo_neuefische.dto.RegisterTodoDTO;
import org.example.recapproject_todo_neuefische.entity.Todo;
import org.example.recapproject_todo_neuefische.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable String id){
        return  todoService.getTodoById(id);
    }

    //Post Mapping
    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody RegisterTodoDTO newUser){
        Todo newTodo = todoService.createNewTodo(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    //Put Mapping
    @PutMapping("/{id}")
    public void updateTodo(@RequestBody ChangeTodoDTO updatedTodo){
        todoService.updateUser(updatedTodo);
    }

    //Delete Mapping
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id){
        todoService.deleteTodoById(id);
    }
}
