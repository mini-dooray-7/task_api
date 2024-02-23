package com.nhnacademy.mini.dooray.service;

import com.nhnacademy.mini.dooray.entity.Task;
import com.nhnacademy.mini.dooray.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getTasksByProjectId(Long projectId) {
        return taskRepository.findAllByProjectId(projectId);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

//    public Task updateTask(Long id, Task updatedTask) {
//        return taskRepository.findById(id).map(task -> {
//          task.setName(updatedTask.getName());
//          task.setDescription(updatedTask.getDescription());
//          task.setDueDate(updatedTask.getDueDate());
//          return taskRepository.save(task);
//        }).orElseThrow(() -> new IllegalArgumentException("Task not found"));
//    }
}