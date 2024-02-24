package com.nhnacademy.mini.dooray.service.impl;

import com.nhnacademy.mini.dooray.exception.NotFoundCommentException;
import com.nhnacademy.mini.dooray.repository.CommentRepository;
import com.nhnacademy.mini.dooray.entity.Comment;
import com.nhnacademy.mini.dooray.request.UpdateCommentDto;
import com.nhnacademy.mini.dooray.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> getComments(Long taskId) {
        return commentRepository.findAllByTask_TaskId(taskId);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void updateComment(Long id, UpdateCommentDto updateCommentDto) {
        Comment res = commentRepository.findById(id).orElse(null);

        if (res == null) throw new NotFoundCommentException();

        res.setCommentContent(updateCommentDto.getContent());
        commentRepository.save(res);
    }
}