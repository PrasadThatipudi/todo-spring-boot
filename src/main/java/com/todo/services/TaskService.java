package com.todo.services;

import com.todo.data.Task;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {
    public ArrayList getAllTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(0, "Read Books", false));

        return tasks;
    }
}
