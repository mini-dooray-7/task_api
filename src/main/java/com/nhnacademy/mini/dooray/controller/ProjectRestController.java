package com.nhnacademy.mini.dooray.controller;

import com.nhnacademy.mini.dooray.entity.Project;
import com.nhnacademy.mini.dooray.request.ProjectPostRequest;
import com.nhnacademy.mini.dooray.request.ProjectUpdateRequest;
import com.nhnacademy.mini.dooray.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectRestController {
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
        Project project = new Project();
        BeanUtils.copyProperties(projectPostRequest, project);

        service.save(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public void updateProject(@PathVariable Long id, @RequestBody ProjectUpdateRequest projectUpdateRequest) {
        Project project = getProject(id);

        if (project == null) throw new RuntimeException("존재하지 않는 project 입니다.");

        BeanUtils.copyProperties(projectUpdateRequest, project);
        service.update(project);
    }
}
