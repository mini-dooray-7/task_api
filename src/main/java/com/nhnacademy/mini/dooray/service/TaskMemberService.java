package com.nhnacademy.mini.dooray.service;

import com.nhnacademy.mini.dooray.entity.TaskMember;

public interface TaskMemberService {
    void save(TaskMember taskMember);

    void delete(TaskMember.Pk pk);
}
