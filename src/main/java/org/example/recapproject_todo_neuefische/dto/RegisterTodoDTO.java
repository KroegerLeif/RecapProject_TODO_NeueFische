package org.example.recapproject_todo_neuefische.dto;

import org.example.recapproject_todo_neuefische.entity.Status;

public record RegisterTodoDTO(String description,
                              Status status) {
}
