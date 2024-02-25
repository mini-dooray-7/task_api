package com.nhnacademy.mini.dooray.entity;

import com.nhnacademy.mini.dooray.domain.ProjectState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "project_name", length = 32)
    private String projectName;

    @Column(name = "project_state")
    private ProjectState projectState;

//    @Column(name = "project_member")
//    @OneToMany(mappedBy = "project")
//    private List<ProjectMember> projectMembers;
//
    @OneToMany(mappedBy = "project", orphanRemoval = true)
    private List<Milestone> milestones;
//
//    @OneToMany(mappedBy = "project", orphanRemoval = true)
//    private List<Tag> tags;

    @OneToMany(mappedBy = "project", orphanRemoval = true)
    private Set<Task> tasks;
}