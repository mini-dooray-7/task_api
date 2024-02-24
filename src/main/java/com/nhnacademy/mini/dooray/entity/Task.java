package com.nhnacademy.mini.dooray.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nhnacademy.mini.dooray.domain.ProjectState;
import com.nhnacademy.mini.dooray.domain.TaskState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @NotNull
    @Column(name = "user_id")
    private String userId;

    @ManyToOne
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

//    @NotNull
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @NotEmpty
    @Column(name = "task_title")
    private String taskTitle;

    @NotEmpty
    @Column(name = "task_content")
    private String taskContent;

    @NotNull
    @Column(name = "task_created_at")
    private LocalDateTime taskCreatedAt;

    @NotNull
    @Column(name = "task_state")
    private TaskState state;

    @OneToMany(mappedBy = "task", orphanRemoval = true)
    @JsonManagedReference
    private Set<Comment> comments;

    public Task() {
        this.taskCreatedAt = LocalDateTime.now();
        this.state = ProjectState.ACTIVE;
    }
}
