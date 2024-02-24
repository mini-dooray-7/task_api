package com.nhnacademy.mini.dooray.service;

import com.nhnacademy.mini.dooray.dto.ProjectMemberPostDto;
import com.nhnacademy.mini.dooray.entity.Project;

public interface ProjectMemberService {
    void save(Project project, ProjectMemberPostDto projectMemberPostDto);

    void delete(Project project, String userId);
}
