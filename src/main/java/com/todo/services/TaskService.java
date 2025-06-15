package com.todo.services;

import com.todo.data.Task;
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

    private Task getTaskById(int taskId) {
        return tasks.stream().filter(task -> task.getId() == taskId).findFirst().orElse(null);
    }

    public Task toggleTaskStatus(int taskId) {
        Task task = getTaskById(taskId);

        return task.toggleTaskStatus();
    }
}
