package com.nhnacademy.mini.dooray.repository;

import com.nhnacademy.mini.dooray.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    CommentRepository commentRepository;

    @Test
    void name() {

        Comment comment = new Comment();

        Comment actual = commentRepository.save(comment);
//        commentRepository.findById(true);

        System.out.println(actual);

    }
}