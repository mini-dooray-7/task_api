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
            "t.state as state, " +
            "c.commentId as commentId, " +
            "c.commentUserId as commentUserId, " +
            "c.commentContent as commentContent " +
            "from Task t " +
            "left join t.comments c " +
            "where t.taskId = :id")
    TaskDto findTaskDtoBy(Long id);

//    TaskDto findTaskDtoBy(Long id);

//    @Query("select t from Task t where t.project.projectId = :projectId and t.taskId = :taskId")
//    Task findByProjectId(@Param("projectId") Long projectId, @Param("taskId") Long taskId);
}