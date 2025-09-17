package org.example.recapproject_todo_neuefische.service;

import org.example.recapproject_todo_neuefische.dto.RegisterTodoDTO;
import org.example.recapproject_todo_neuefische.entity.Todo;
import org.example.recapproject_todo_neuefische.repro.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
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

    public void createNewTodo(RegisterTodoDTO registerTodoDTO){
        todoRepository.save(mapRegisterToTodo(registerTodoDTO));
    }

    public Todo getTodoById(String id){
        Todo todoWithID =  todoRepository.findById(id).orElse(null);
        if(todoWithID == null){
            return null;
        }else{
            return todoWithID;
        }
    }

    //Helper Methods
    private Todo mapRegisterToTodo(RegisterTodoDTO registerTodoDTO){
        Todo newTodo = new Todo(IdService.generateId(),
                                "No Title",
                                registerTodoDTO.discription(),
                                registerTodoDTO.status(),
                                Instant.now());
        return newTodo;
    }


}
