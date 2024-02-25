package com.nhnacademy.mini.dooray.service;

import com.nhnacademy.mini.dooray.dto.CommentDto;
import com.nhnacademy.mini.dooray.entity.Comment;
import com.nhnacademy.mini.dooray.entity.Task;
import com.nhnacademy.mini.dooray.request.CommentPostDto;
import com.nhnacademy.mini.dooray.request.CommentUpdateDto;

import java.util.List;

public interface CommentService {
//    List<Comment> getComments(Long taskId);

    List<CommentDto> getCommentDto(Long taskId);

    Comment getComment(Long id);

    void save(Task task, CommentPostDto commentPostDto);

    void delete(Long id);

    void updateComment(Long id, CommentUpdateDto commentUpdateDto);
}
