package com.todo.controllers;

import com.todo.data.Task;
import com.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/tasks")
    public Object getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks/add")
    public Task addTask() {
        return taskService.addTask("Mock Task");
    }

    @PatchMapping("/tasks/{id}/status")
    public Task toggleTaskStatus(@PathVariable Long id) {
        return taskService.toggleTaskStatus(0);
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(0);
    }
}
