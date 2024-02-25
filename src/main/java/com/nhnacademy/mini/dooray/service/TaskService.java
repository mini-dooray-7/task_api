package com.nhnacademy.mini.dooray.service;

import com.nhnacademy.mini.dooray.dto.TaskDto;
import com.nhnacademy.mini.dooray.entity.Project;
import com.nhnacademy.mini.dooray.entity.Task;
import com.nhnacademy.mini.dooray.request.TaskPostDto;

import java.util.List;
import java.util.Set;

public interface TaskService {
    void save(Project project, TaskPostDto task);

    TaskDto getTaskDto(Long id);

    Task getTask(Long id);

    List<TaskDto> getTasks(Long projectId);

    void deleteTask(Long id);
}
