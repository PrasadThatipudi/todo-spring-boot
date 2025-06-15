package com.todo.controllers;

import com.todo.data.Task;
import com.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/tasks")
    public Object getAllTasks() {
        return taskService.getAllTasks();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/tasks/add")
    public Task addTask() {
        return taskService.addTask("Mock Task");
    }
}
