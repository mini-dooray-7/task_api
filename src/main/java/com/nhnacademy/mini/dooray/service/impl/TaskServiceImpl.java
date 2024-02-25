package com.nhnacademy.mini.dooray.service.impl;

import com.nhnacademy.mini.dooray.dto.TaskDto;
import com.nhnacademy.mini.dooray.entity.Project;
import com.nhnacademy.mini.dooray.entity.Task;
import com.nhnacademy.mini.dooray.repository.TaskRepository;
import com.nhnacademy.mini.dooray.request.TaskPostDto;
import com.nhnacademy.mini.dooray.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public void save(Project project, TaskPostDto taskPostDto) {
        Task task = new Task();

        BeanUtils.copyProperties(taskPostDto, task);
        task.setProject(project);

        taskRepository.save(task);
    }

    @Override
    public TaskDto getTaskDto(Long id) {
        return taskRepository.findTaskDtoById(id);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<TaskDto> getTasks(Long projectId) {
        return taskRepository.findAllByProjectId(projectId);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}