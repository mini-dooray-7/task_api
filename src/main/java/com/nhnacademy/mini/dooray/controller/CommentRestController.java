package com.nhnacademy.mini.dooray.controller;

import com.nhnacademy.mini.dooray.entity.Comment;
import com.nhnacademy.mini.dooray.request.UpdateCommentDto;
import com.nhnacademy.mini.dooray.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.nhnacademy.mini.dooray.repository.CommentRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentRestController {
    private final CommentService commentService;

    @GetMapping("/{taskId}")
    public List<Comment> getComments(@PathVariable Long taskId) {
        return commentService.getComments(taskId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@RequestBody Comment comment) {
        commentService.save(comment);
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