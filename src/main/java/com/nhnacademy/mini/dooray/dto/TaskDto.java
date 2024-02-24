package com.nhnacademy.mini.dooray.dto;

import com.nhnacademy.mini.dooray.domain.ProjectState;
import com.nhnacademy.mini.dooray.entity.Milestone;
import com.nhnacademy.mini.dooray.entity.Project;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskDto {
    Long getTaskId();

    String getUserId();

    Milestone getMilestone();

//    String getTaskTitle();

    String getTaskContent();

    LocalDateTime getTaskCreatedAt();

    ProjectState getState();

    // Project getProject();

    List<CommentDto> getComments();

    interface CommentDto {
        Long getCommentId();

        String getCommentUserId();

        String getCommentContent();
    }
}
