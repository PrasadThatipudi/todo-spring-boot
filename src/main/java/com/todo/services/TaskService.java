package com.todo.services;

import com.todo.data.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {
    private ArrayList<Task> tasks = new ArrayList<>();
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

    private Task getTaskById(int taskId) {
        return tasks.stream().filter(task -> task.getId() == taskId).findFirst().orElse(null);
    }

    public Task toggleTaskStatus(int taskId) {
        Task task = getTaskById(taskId);

        return task.toggleTaskStatus();
    }

    public Task deleteTask(int taskId) {
        Task targetTask = getTaskById(taskId);

        tasks.remove(targetTask);
        return targetTask;
    }
}
