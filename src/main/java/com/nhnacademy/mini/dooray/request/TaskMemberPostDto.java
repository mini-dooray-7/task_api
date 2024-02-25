package com.nhnacademy.mini.dooray.request;

import com.nhnacademy.mini.dooray.domain.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskMemberPostDto {
    String taskUserId;
    String taskUserRole;
}
