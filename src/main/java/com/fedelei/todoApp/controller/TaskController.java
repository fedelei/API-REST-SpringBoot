package com.fedelei.todoApp.controller;

import com.fedelei.todoApp.service.DTO.TaskInDto;
import com.fedelei.todoApp.service.TaskService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fedelei.todoApp.persistence.entity.Task;
import com.fedelei.todoApp.persistence.entity.TaskStatus;
import java.util.List;
//Controlador
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDto taskInDto) {
        return this.taskService.createTask(taskInDto);
    }

    @GetMapping
    public List<Task> findAll() {
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status") TaskStatus status) {
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id) {
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
