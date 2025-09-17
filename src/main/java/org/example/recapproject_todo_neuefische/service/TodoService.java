package org.example.recapproject_todo_neuefische.service;

import org.example.recapproject_todo_neuefische.entity.Todo;
import org.example.recapproject_todo_neuefische.repro.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /**
     * Find all todos.
     * @return A List of todos.
     */
    public List<Todo> findAll(){
        return todoRepository.findAll();
    }


}
