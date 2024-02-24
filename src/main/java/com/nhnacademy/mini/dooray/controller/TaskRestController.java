package com.nhnacademy.mini.dooray.controller;

import com.nhnacademy.mini.dooray.dto.TaskDto;
import com.nhnacademy.mini.dooray.entity.Project;
import com.nhnacademy.mini.dooray.entity.Task;
import com.nhnacademy.mini.dooray.request.TaskPostDto;
import com.nhnacademy.mini.dooray.service.ProjectService;
import com.nhnacademy.mini.dooray.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskRestController {
    private final ProjectService projectService;
    private final TaskService taskService;

    @GetMapping("/{id}")
    public TaskDto getTask(@PathVariable Long id) {
        System.out.println();
        return taskService.getTaskDto(id);
//        return null;
    }

    @GetMapping("/projects/{projectId}")
    public List<Task> getTasks(@PathVariable Long projectId) {
        return taskService.getTasks(projectId);
    }

    @PostMapping("/projects/{projectId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable Long projectId, @RequestBody TaskPostDto taskPostDto) {
        Project project = projectService.getProject(projectId);

        taskService.save(project, taskPostDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping
    public void update(Project project) {
        // todo implement update.
    }
}
