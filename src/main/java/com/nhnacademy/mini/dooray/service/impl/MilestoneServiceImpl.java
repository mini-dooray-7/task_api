package com.nhnacademy.mini.dooray.service.impl;

import com.nhnacademy.mini.dooray.entity.Milestone;
import com.nhnacademy.mini.dooray.repository.MilestoneRepository;
import com.nhnacademy.mini.dooray.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class MilestoneServiceImpl implements MilestoneService {
    private final MilestoneRepository repository;

    @Override
    public void createMilestone(Milestone milestone) {
        repository.save(milestone);
    }

    @Override
    public List<Milestone> getAllMilestones() {
        return repository.findAll();
    }

    @Override
    public Milestone getMilestoneById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
