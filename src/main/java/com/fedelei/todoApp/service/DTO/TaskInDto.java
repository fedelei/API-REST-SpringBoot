package com.fedelei.todoApp.service.DTO;

import com.fedelei.todoApp.persistence.entity.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskInDto {

    private String title;
    private String descrpition;
    private LocalDateTime eta; //Fecha de finalizacion de la tarea

}
