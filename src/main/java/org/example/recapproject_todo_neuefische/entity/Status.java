package org.example.recapproject_todo_neuefische.entity;

public enum Status {
    OPEN("Open"),
    DO("Do"),
    DOING("Doing"),
    CLOSED( "Closed");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
