package com.fedelei.todoApp.mapper;

import com.fedelei.todoApp.persistence.entity.Task;
import com.fedelei.todoApp.persistence.entity.TaskStatus;
import com.fedelei.todoApp.service.DTO.TaskInDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDtoToTask implements IMapper<TaskInDto, Task>{

    @Override
    public Task map(TaskInDto in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescrpition(in.getDescrpition());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
