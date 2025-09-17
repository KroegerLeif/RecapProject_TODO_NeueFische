package org.example.recapproject_todo_neuefische.entity;

public enum Status {
    OPEN("Open"),
    CLOSED( "Closed"),
    IN_PROGRESS("In Progress");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
