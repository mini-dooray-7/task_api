package com.nhnacademy.mini.dooray.repository;

import com.nhnacademy.mini.dooray.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
