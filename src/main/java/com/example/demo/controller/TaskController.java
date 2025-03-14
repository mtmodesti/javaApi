package com.example.demo.controller;

import com.example.demo.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    // Criar uma nova task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        tasks.add(task);
        return task;
    }

    // Listar todas as tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }
}
