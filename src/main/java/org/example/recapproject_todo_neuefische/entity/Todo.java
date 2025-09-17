package org.example.recapproject_todo_neuefische.entity;

import lombok.With;

import java.time.Instant;

@With
public record Todo(String id,
                   String description,
                   Status status,
                   Instant created) {
}
