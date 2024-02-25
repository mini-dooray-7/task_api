package com.nhnacademy.mini.dooray.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(name = "comment_user_id")
    private String commentUserId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @NotNull
    @Column(name = "comment_content")
    private String commentContent = Strings.EMPTY;
}