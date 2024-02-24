package com.nhnacademy.mini.dooray.dto;

import com.nhnacademy.mini.dooray.domain.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProjectMemberPostDto {
    private String memberId;
    private RoleType role;
}
