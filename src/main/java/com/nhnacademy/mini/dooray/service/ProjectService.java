package com.nhnacademy.mini.dooray.service;

import com.nhnacademy.mini.dooray.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getProjects();

    Project getProject(Long id);

    void save(Project project);

    void update(Project project);

    void delete(Long id);
}
