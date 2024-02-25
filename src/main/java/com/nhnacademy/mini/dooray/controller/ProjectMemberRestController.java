package com.nhnacademy.mini.dooray.controller;

import com.nhnacademy.mini.dooray.dto.ProjectMemberPostDto;
import com.nhnacademy.mini.dooray.entity.Project;
import com.nhnacademy.mini.dooray.service.ProjectMemberService;
import com.nhnacademy.mini.dooray.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectMemberRestController {
    public final ProjectService projectService;
    public final ProjectMemberService service;

    @PostMapping("{id}/members")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable Long id, ProjectMemberPostDto projectMemberPostDto) {
        Project project = projectService.getProject(id);

        service.save(project, projectMemberPostDto);
    }

    @DeleteMapping("{id}/members/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@PathVariable Long id, @PathVariable String userId) {
        Project project = projectService.getProject(id);

        service.delete(project, userId);
    }
}
