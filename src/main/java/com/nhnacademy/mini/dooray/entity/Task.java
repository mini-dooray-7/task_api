package com.nhnacademy.mini.dooray.entity;

import com.nhnacademy.mini.dooray.domain.ProjectState;
import com.nhnacademy.mini.dooray.domain.TaskState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @ManyToOne
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_content")
    private String taskContent;

    @Column(name = "task_created_at")
    private LocalDateTime taskCreatedAt;

    @Column(name = "task_state")
    private TaskState state;

    @OneToMany(mappedBy = "task")
    private List<Comment> comments;
}
