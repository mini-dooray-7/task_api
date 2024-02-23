package com.nhnacademy.mini.dooray.repository;

import com.nhnacademy.mini.dooray.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select c from Comment c where c.task.taskId = :taskId")
    List<Comment> findAllCommentByTaskId(@Param("taskId") Long taskId);
}
