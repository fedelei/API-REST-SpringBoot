package com.fedelei.todoApp.service;

import com.fedelei.todoApp.exceptions.ToDoExceptions;
import com.fedelei.todoApp.mapper.TaskInDtoToTask;
import com.fedelei.todoApp.persistence.entity.Task;
import com.fedelei.todoApp.persistence.entity.TaskStatus;
import com.fedelei.todoApp.persistence.repository.TaskRepository;
import com.fedelei.todoApp.service.DTO.TaskInDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final TaskInDtoToTask mapper;

    public TaskService(TaskRepository repository, TaskInDtoToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public Task createTask(TaskInDto taskinDto){
        Task task = mapper.map(taskinDto);
        return this.repository.save(task);

    }

    public List<Task> findAll() {
        return this.repository.findAll();
    }
    public List<Task> findAllByTaskStatus(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }
    @Transactional
    public void updateTaskAsFinished(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);

        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task Not Found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

    public void deleteById(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task Not Found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }


}
