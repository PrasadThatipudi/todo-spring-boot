package com.todo.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void shouldInstantiateTask(){
        Task task = new Task(0, "Task-1", false);

        assertEquals(new Task(0, "Task-1", false), task);
    }

    @Test
    void shouldToggleTaskStatus(){
        Task task = new Task(0, "Task-1", false);

        task.toggleTaskStatus();

        assertEquals(true, task.isDone());
        task.toggleTaskStatus();
        assertEquals(false, task.isDone());
    }
 }