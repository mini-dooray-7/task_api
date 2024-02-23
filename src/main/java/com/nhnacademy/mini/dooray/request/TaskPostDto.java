package com.nhnacademy.mini.dooray.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TaskPostDto {
    private String userID;
    private String taskTitle;
    private String taskContent;
}
