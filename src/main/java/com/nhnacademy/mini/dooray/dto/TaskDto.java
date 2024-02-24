package com.nhnacademy.mini.dooray.dto;

import com.nhnacademy.mini.dooray.domain.ProjectState;
import com.nhnacademy.mini.dooray.entity.Milestone;
import com.nhnacademy.mini.dooray.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public interface TaskDto {
    Long getTaskId();
    String getUserId();
    Milestone getMilestone();
    String getTaskTitle();
    String getTaskContent();
    LocalDateTime getTaskCreatedAt();
    ProjectState getState();
    Project getProject();

//    List<CommentDto> findCommentsByTaskId(Long taskId);
}
