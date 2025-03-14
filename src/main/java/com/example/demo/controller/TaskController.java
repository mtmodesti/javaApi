package com.example.demo.controller;

import com.example.demo.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    // Atualizar uma task existente
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        for (Task t : tasks) {
            if (t.getId().equals(id)) {
                t.setDescription(task.getDescription());
                t.setCompleted(task.isCompleted());
                return t;
            }
        }
        return null; // Caso não encontre a task
    }

    // Deletar uma task pelo id
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        Optional<Task> taskToRemove = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();

        if (taskToRemove.isPresent()) {
            tasks.remove(taskToRemove.get());
            return "Task com ID " + id + " deletada com sucesso!";
        } else {
            return "Task com ID " + id + " não encontrada!";
        }
    }
}
