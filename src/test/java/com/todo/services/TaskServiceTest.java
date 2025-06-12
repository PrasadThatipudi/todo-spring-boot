package com.todo.services;

import com.todo.data.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void shouldReturnAllTasks() {
        TaskService taskService = new TaskService();
        Task task = new Task(0, "Read Books", false);

        ArrayList allTasks = taskService.getAllTasks();
        assertNotNull(allTasks);
        assertEquals(allTasks.size(), 1);
        assertEquals(task, allTasks.get(0));
    }
}