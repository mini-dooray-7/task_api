package com.nhnacademy.mini.dooray.controller;

import com.nhnacademy.mini.dooray.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.nhnacademy.mini.dooray.repository.CommentRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentRestController {
    private final CommentRepository repository;

    @GetMapping
    public List<Comment> getComments() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@RequestBody Comment comment) {
        repository.save(comment);
    }

//    @GetMapping(value = "/{id}")
//    public Comment getCommentById(@PathVariable Long id) {
//        return repository.findById(id).orElse(null);
//    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment comment) {
        return repository.save(comment);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteComment(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}