package com.todo.services;

import com.todo.data.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void shouldReturnAllTasks() {
        TaskService taskService = new TaskService();
        taskService.addTask("Task-1");
        Task task = new Task(0, "Task-1", false);

        ArrayList allTasks = taskService.getAllTasks();
        assertNotNull(allTasks);
        assertEquals(allTasks.size(), 1);
        assertEquals(task, allTasks.get(0));
    }

    @Test
    void shouldReturnEmptyList() {
        TaskService taskService = new TaskService();

        assertEquals(new ArrayList<Task>(), taskService.getAllTasks());
    }

    @Test
    void shouldAddTask() {
        TaskService taskService = new TaskService();

        Task task = taskService.addTask("Task-1");
        assertEquals(new Task(0, "Task-1", false), task);
    }

    @Test
    void serviceShouldNotContainMoreThanOneTaskAfterAddingOneTask() {
        TaskService taskService = new TaskService();
        Task task = taskService.addTask("Task-1");

        assertEquals(1, taskService.getAllTasks().size());
    }

    @Test
    void serviceShouldContainAllTasksWhichAdded() {
        TaskService taskService = new TaskService();

        taskService.addTask("Task-1");
        taskService.addTask("Task-2");


        assertEquals(2, taskService.getAllTasks().size());
    }
}