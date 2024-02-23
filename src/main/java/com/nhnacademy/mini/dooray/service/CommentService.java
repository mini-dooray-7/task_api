package com.nhnacademy.mini.dooray.service;

import com.nhnacademy.mini.dooray.entity.Comment;
import com.nhnacademy.mini.dooray.request.UpdateCommentDto;

import java.util.List;

public interface CommentService {
    List<Comment> getComments(Long taskId);

    public List<Comment> getComments();

    Comment getComment(Long id);

    Comment save(Comment comment);

    void delete(Long id);

    void updateComment(Long id, UpdateCommentDto updateCommentDto);
}
