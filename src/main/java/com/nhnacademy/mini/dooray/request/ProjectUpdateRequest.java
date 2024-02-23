package com.nhnacademy.mini.dooray.request;

import com.nhnacademy.mini.dooray.domain.ProjectState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProjectUpdateRequest {
    private String projectName;
    private ProjectState projectState;
}
