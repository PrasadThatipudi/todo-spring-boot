package com.todo.services;

import com.todo.data.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {
        ArrayList<Task> tasks = new ArrayList<>();
    public ArrayList getAllTasks() {
        tasks.add(new Task(0, "Read Books", false));

        return tasks;
    }

    public Task addTask(String description){
        if(hasTask(description)) throw new IllegalArgumentException("Description already exists");

        return new Task(0, description, false);
    }

    private boolean hasTask(String description) {
        return tasks.stream().anyMatch(task -> task.getDescription().equals(description));
    }
}
