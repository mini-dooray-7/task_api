package com.nhnacademy.mini.dooray.repository;

import com.nhnacademy.mini.dooray.entity.TaskMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskMemberRepository extends JpaRepository<TaskMember, TaskMember.Pk> {
}
