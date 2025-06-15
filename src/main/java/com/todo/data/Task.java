package com.todo.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Task {

    private final int id;
    private final String description;
    private boolean done;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && done == task.done && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, done);
    }

    public Task toggleTaskStatus() {
        done = !done;

        return this;
    }
}
