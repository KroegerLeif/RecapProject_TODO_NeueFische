package org.example.recapproject_todo_neuefische.entity;

import java.time.Instant;

public record Todo(String id,
                   String title,
                   String description,
                   Instant created) {
}
