package com.nhnacademy.mini.dooray.service;

import com.nhnacademy.mini.dooray.dto.ProjectMemberPostDto;
import com.nhnacademy.mini.dooray.entity.Project;
import com.nhnacademy.mini.dooray.entity.ProjectMember;
import com.nhnacademy.mini.dooray.repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {
    private final ProjectMemberRepository projectMemberRepository;

    @Override
    public void save(Project project, ProjectMemberPostDto projectMemberPostDto) {
        ProjectMember projectMember = new ProjectMember();

        BeanUtils.copyProperties(projectMemberPostDto, projectMember);
        projectMember.setProject(project);
        projectMember.setPk(new ProjectMember.Pk(projectMemberPostDto.getMemberId(), project.getProjectId()));

        projectMemberRepository.save(projectMember);
    }

    @Override
    public void delete(Project project, String userId) {
        projectMemberRepository.deleteById(new ProjectMember.Pk(userId, project.getProjectId()));
    }
}
