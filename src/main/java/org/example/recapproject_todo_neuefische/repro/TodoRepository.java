package org.example.recapproject_todo_neuefische.repro;

import org.example.recapproject_todo_neuefische.entity.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends MongoRepository<Todo,String>{
    List<Todo> findAll();
}
