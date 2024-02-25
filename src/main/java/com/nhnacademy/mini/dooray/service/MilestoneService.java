package com.nhnacademy.mini.dooray.service;

import com.nhnacademy.mini.dooray.entity.Milestone;

import java.util.List;

public interface MilestoneService {
    void createMilestone(Milestone milestone);

    List<Milestone> getAllMilestones();

    Milestone getMilestoneById(Long id);

    void delete(Long id);
}
