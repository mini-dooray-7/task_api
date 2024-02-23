package com.nhnacademy.mini.dooray.service;

import com.nhnacademy.mini.dooray.repository.CommentRepository;
import com.nhnacademy.mini.dooray.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    // write your methods here.

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

//    public Comment updateComment(Comment comment, Long id) {
//        return commentRepository.findById(id)
//            .map(commentObj -> {
//                commentObj.setText(comment.getText());
//                // set other properties as needed
//                return commentRepository.save(commentObj);
//            })
//            .orElseGet(() -> {
//                comment.setId(id);
//                return commentRepository.save(comment);
//            });
//    }

}