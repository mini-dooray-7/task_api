package com.nhnacademy.mini.dooray.controller;

import com.nhnacademy.mini.dooray.entity.Comment;
import com.nhnacademy.mini.dooray.entity.Task;
import com.nhnacademy.mini.dooray.request.CommentPostDto;
import com.nhnacademy.mini.dooray.request.UpdateCommentDto;
import com.nhnacademy.mini.dooray.service.CommentService;
import com.nhnacademy.mini.dooray.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentRestController {
    private final TaskService taskService;
    private final CommentService commentService;

    @GetMapping("/tasks/{taskId}")
    public List<Comment> getComments(@PathVariable Long taskId) {
        return commentService.getComments(taskId);
    }

    @PostMapping("/tasks/{taskId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@RequestBody CommentPostDto commentPostDto, @PathVariable Long taskId) {
        Task task = taskService.getTask(taskId);

        commentService.save(task, commentPostDto);
    }


    @PutMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody UpdateCommentDto updateCommentDto) { // todo add controller advise.
        commentService.updateComment(id, updateCommentDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteComment(@PathVariable("id") Long id) {
        commentService.delete(id);
    }
}