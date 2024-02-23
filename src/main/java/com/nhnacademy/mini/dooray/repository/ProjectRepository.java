package com.nhnacademy.mini.dooray.repository;

import com.nhnacademy.mini.dooray.dto.ProjectInfo;
import com.nhnacademy.mini.dooray.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

//    @Query("select proj from Project proj join ProjectMember pm where pm.projectUserRole = 'ADMIN' and proj.projectId = :id")
//     findAllProjectWithAdminId(@Param("id") Long id);
}
