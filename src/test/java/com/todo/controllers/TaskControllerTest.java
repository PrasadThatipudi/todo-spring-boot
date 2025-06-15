package com.todo.controllers;

import com.todo.data.Task;
import com.todo.services.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    TaskService taskService;

    @Test
    void shouldReturnEmptyArrayIfThereAreNoTasks() throws Exception {
        when(taskService.getAllTasks()).thenReturn(new ArrayList<>());
        var task = new Task(1, "hello", false);

        task.getDescription();

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
    }

    @Test
    void shouldReturnAllTasks() throws Exception {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(0, "Mock Task", false));

        when(taskService.getAllTasks()).thenReturn(tasks);
        mockMvc.perform(get("/tasks").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\": 0, \"description\": \"Mock Task\", \"done\": false}]"));
    }

    @Test
    void shouldAddTask() throws Exception {
        Task task = new Task(0, "Mock Task", false);

        when(taskService.addTask("Mock Task")).thenReturn(task);
        mockMvc.perform(post("/tasks/add")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"description\": \"Mock Task\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json("{\"id\": 0, \"description\": \"Mock Task\", \"done\": false}"));
    }

    @Test
    void shouldUpdateTaskStatus() throws Exception {
        Task task = new Task(0, "Mock Task", true);

        taskService.addTask("Mock Task");
        when(taskService.toggleTaskStatus(0)).thenReturn(task);
        mockMvc.perform(patch("/tasks/0/status"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\": 0, \"description\": \"Mock Task\" , \"done\": true}"));
    }
}