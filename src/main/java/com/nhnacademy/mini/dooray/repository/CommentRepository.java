package com.nhnacademy.mini.dooray.repository;

import com.nhnacademy.mini.dooray.dto.CommentDto;
import com.nhnacademy.mini.dooray.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select c.commentId as commentId, c.commentUserId as commentUserId, c.commentContent as commentContent " +
            "from Comment c where c.task.taskId = :id")
    List<CommentDto> findCommentsByTaskId(@Param("id") Long id);
}
