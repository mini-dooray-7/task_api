package com.nhnacademy.mini.dooray.service.impl;

import com.nhnacademy.mini.dooray.domain.ProjectState;
import com.nhnacademy.mini.dooray.entity.Project;
import com.nhnacademy.mini.dooray.entity.ProjectMember;
import com.nhnacademy.mini.dooray.repository.ProjectRepository;
import com.nhnacademy.mini.dooray.request.ProjectPostRequest;
import com.nhnacademy.mini.dooray.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProject(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Project project) {
        if (projectRepository.existsById(project.getProjectId())) throw new IllegalStateException();

        projectRepository.save(project);
    }

    @Override
    public void update(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void delete(Long id) {
        if (projectRepository.existsById(id)) projectRepository.deleteById(id);
    }
}
