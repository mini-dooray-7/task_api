package com.nhnacademy.mini.dooray.service;

import com.nhnacademy.mini.dooray.domain.ProjectState;
import com.nhnacademy.mini.dooray.entity.Project;
import com.nhnacademy.mini.dooray.entity.ProjectMember;
import com.nhnacademy.mini.dooray.repository.ProjectRepository;
import com.nhnacademy.mini.dooray.request.ProjectPostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(Long id) {
        Optional<Project> res = projectRepository.findById(id);

        return res.orElse(null);
    }

    public void save(Project project) {
        if (projectRepository.existsById(project.getProjectId())) throw new RuntimeException(); // todo throw already exist exception.

        projectRepository.save(project);
    }

    public void update(Project project) { // todo updateObj
        projectRepository.save(project);
    }

    public void delete(Long id) {
        if (projectRepository.existsById(id)) projectRepository.deleteById(id);
    }

    public Project toProject(ProjectPostRequest projectPostRequest) {
        Project project = new Project();

        project.setProjectName(projectPostRequest.getProjectName());
        project.setProjectState(ProjectState.ACTIVE);

        List<ProjectMember> members;
//        for (int i = 0; i < projectPostRequest.getProjectAdminIds().length; ++i) {
//            ProjectMember projectMember = new ProjectMember();
//
//            projectMember.setProject(project.getProjectId());
//            projectPostRequest.getProjectAdmins()[i]
//
//        }
//        ProjectMember projectMember new ProjectMember();

        return project;
    }
}
