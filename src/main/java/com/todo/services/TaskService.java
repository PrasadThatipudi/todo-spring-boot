package com.todo.services;

import com.todo.data.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {
    ArrayList<Task> tasks = new ArrayList<>();
    private int currentTaskId = -1;

    public ArrayList getAllTasks() {
        return tasks;
    }

    public Task addTask(String description){
        Task newTask = new Task(nextTaskId(), description, false);
        tasks.add(newTask);

        return newTask;
    }

    private int nextTaskId() {
        currentTaskId += 1;

        return currentTaskId;
    }

    private boolean hasTask(String description) {
        return tasks.stream().anyMatch(task -> task.getDescription().equals(description));
    }
}
