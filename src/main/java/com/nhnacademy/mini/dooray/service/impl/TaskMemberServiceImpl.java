package com.nhnacademy.mini.dooray.service.impl;

import com.nhnacademy.mini.dooray.entity.TaskMember;
import com.nhnacademy.mini.dooray.repository.TaskMemberRepository;
import com.nhnacademy.mini.dooray.service.TaskMemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class TaskMemberServiceImpl implements TaskMemberService {
    private final TaskMemberRepository taskMemberRepository;

    @Override
    public void save(TaskMember taskMember) {
        taskMemberRepository.save(taskMember);
    }

    @Override
    public void delete(TaskMember.Pk pk) {
        taskMemberRepository.deleteById(pk);
    }
}
