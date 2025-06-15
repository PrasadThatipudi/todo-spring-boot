package com.todo.controllers;

import com.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Object addTask() {
        return taskService.addTask("Mock Task");
    }
}
