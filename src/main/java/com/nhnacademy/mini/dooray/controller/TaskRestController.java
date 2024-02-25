package com.nhnacademy.mini.dooray.controller;

import com.nhnacademy.mini.dooray.domain.RoleType;
import com.nhnacademy.mini.dooray.dto.TaskDto;
import com.nhnacademy.mini.dooray.entity.Project;
import com.nhnacademy.mini.dooray.entity.Task;
import com.nhnacademy.mini.dooray.entity.TaskMember;
import com.nhnacademy.mini.dooray.exception.NotFoundProjectException;
import com.nhnacademy.mini.dooray.exception.NotFoundTaskException;
import com.nhnacademy.mini.dooray.request.TaskMemberPostDto;
import com.nhnacademy.mini.dooray.request.TaskPostDto;
import com.nhnacademy.mini.dooray.service.CommentService;
import com.nhnacademy.mini.dooray.service.ProjectService;
import com.nhnacademy.mini.dooray.service.TaskMemberService;
import com.nhnacademy.mini.dooray.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskRestController {
    private final ProjectService projectService;
    private final TaskService taskService;
    private final TaskMemberService taskMemberService;

    @GetMapping("/{id}")
    public TaskDto getTask(@PathVariable Long id) {
        return taskService.getTaskDto(id);
    }

    @GetMapping("/projects/{projectId}")
    public List<TaskDto> getTasks(@PathVariable Long projectId) {
        return taskService.getTasks(projectId);
    }

    @PostMapping("/projects/{projectId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable Long projectId, @RequestBody TaskPostDto taskPostDto) {
        Project project = projectService.getProject(projectId);

        if (project == null) throw new NotFoundProjectException();

        taskService.save(null, taskPostDto); // todo 임시
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping("/{id}/members")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMember(@PathVariable Long id, @RequestBody TaskMemberPostDto taskMemberPostDto) {
        Task task = taskService.getTask(id);
        if (task == null) throw new NotFoundTaskException();

        TaskMember taskMember = new TaskMember();

        taskMember.setPk(new TaskMember.Pk(taskMemberPostDto.getTaskUserId(), id));
        taskMember.setTask(task);
        taskMember.setTaskUserRole(RoleType.valueOf(taskMemberPostDto.getTaskUserRole().toUpperCase()));

        taskMemberService.save(taskMember);
    }

    @DeleteMapping("{id}/members/{memberId}")
    public void deleteMember(@PathVariable Long id, @PathVariable String memberId) {
        Task task = taskService.getTask(id);
        if (task == null) throw new NotFoundTaskException();

        taskMemberService.delete(new TaskMember.Pk(memberId, task.getTaskId()));
    }

}
