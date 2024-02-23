package com.nhnacademy.mini.dooray.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProjectPostRequest {
    private String projectName;
    private String[] projectAdminIds;
}
