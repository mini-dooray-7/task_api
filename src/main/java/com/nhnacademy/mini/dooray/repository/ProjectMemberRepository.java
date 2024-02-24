package com.nhnacademy.mini.dooray.repository;

import com.nhnacademy.mini.dooray.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMember.Pk> {
}
