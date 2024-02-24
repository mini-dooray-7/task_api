package com.nhnacademy.mini.dooray.service;

import com.nhnacademy.mini.dooray.entity.Comment;
import com.nhnacademy.mini.dooray.entity.Task;
import com.nhnacademy.mini.dooray.request.CommentPostDto;
import com.nhnacademy.mini.dooray.request.UpdateCommentDto;

import java.util.List;

public interface CommentService {
    List<Comment> getComments(Long taskId);

    Comment getComment(Long id);

    void save(Task task, CommentPostDto commentPostDto);

    void delete(Long id);

    void updateComment(Long id, UpdateCommentDto updateCommentDto);
}
