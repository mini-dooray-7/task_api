package com.nhnacademy.mini.dooray.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TaskDetail {
    private TaskDto dto;
    private List<CommentDto> comments;
}
