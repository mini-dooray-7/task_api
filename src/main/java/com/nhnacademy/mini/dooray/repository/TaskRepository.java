package com.nhnacademy.mini.dooray.repository;

import com.nhnacademy.mini.dooray.dto.TaskDto;
import com.nhnacademy.mini.dooray.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("select t from Task t where t.project.projectId = :projectId")
    List<Task> findAllByProjectId(@Param("projectId") Long projectId);

    @Query("select " +
            "t.taskId as taskId, " +
            "t.userId as userId, " +
            "t.taskTitle as taskTitle, " +
            "t.taskContent as taskContent, " +
            "t.taskCreatedAt as taskCreatedAt, " +
            "t.state as state " +
            "from Task t " +
            "where t.taskId = :id")
    TaskDto findTaskDtoById11(@Param("id") Long id);
}