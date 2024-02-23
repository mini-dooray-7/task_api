package com.nhnacademy.mini.dooray.controller;

import com.nhnacademy.mini.dooray.entity.Project;
import com.nhnacademy.mini.dooray.request.ProjectPostRequest;
import com.nhnacademy.mini.dooray.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskRestController {
    private final ProjectService service;

    @GetMapping("/{id}")
    public Project getProject(@PathVariable Long id) {
        return service.getProject(id);
    }

    @GetMapping
    public List<Project> getProject() {
        return service.getProjects();
    }

    @PostMapping
    public void postProject(ProjectPostRequest projectPostRequest) {
        Project project = service.toProject(projectPostRequest);

        service.save(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping
    public void a(Project project) {

    }
}
