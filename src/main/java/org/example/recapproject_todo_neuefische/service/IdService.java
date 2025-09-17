package org.example.recapproject_todo_neuefische.service;

public class IdService {
    public static String generateId(){
        return java.util.UUID.randomUUID().toString();
    }
}
