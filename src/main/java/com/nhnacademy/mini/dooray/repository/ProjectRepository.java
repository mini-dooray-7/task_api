package com.nhnacademy.mini.dooray.repository;

import com.nhnacademy.mini.dooray.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
