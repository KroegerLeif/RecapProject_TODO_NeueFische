package org.example.recapproject_todo_neuefische.service;

import org.example.recapproject_todo_neuefische.dto.ChangeTodoDTO;
import org.example.recapproject_todo_neuefische.dto.RegisterTodoDTO;
import org.example.recapproject_todo_neuefische.entity.Todo;
import org.example.recapproject_todo_neuefische.exception.UserNotFoundException;
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

    public void updateUser(ChangeTodoDTO changeTodoDTO){
        Todo updatedTodo = mapChangeToTodo(changeTodoDTO);
        todoRepository.save(updatedTodo);
    }

    public Todo getTodoById(String id) throws UserNotFoundException{
        return todoRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("No User Found with ID: " + id + "")
        );
    }

    //Helper Methods
    private Todo mapRegisterToTodo(RegisterTodoDTO registerTodoDTO){
        return new Todo(IdService.generateId(),
                                "No Title",
                                registerTodoDTO.description(),
                                registerTodoDTO.status(),
                                Instant.now());
    }

    private Todo mapChangeToTodo(ChangeTodoDTO changeTodoDTO){
        Todo updatedTodo = getTodoById(changeTodoDTO.id());
        //Updates the Dto with the new values
        updatedTodo.withDescription(changeTodoDTO.description());
        updatedTodo.withStatus(changeTodoDTO.status());
        updatedTodo.withTitle(changeTodoDTO.title());
        return updatedTodo;
    }


}
