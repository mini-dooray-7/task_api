package com.nhnacademy.mini.dooray.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.mini.dooray.entity.Comment;
import com.nhnacademy.mini.dooray.request.CommentPostDto;
import com.nhnacademy.mini.dooray.request.UpdateCommentDto;
import com.nhnacademy.mini.dooray.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CommentRestControllerTest {
    @Autowired
    CommentService commentService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getComments() throws Exception {
        Long taskId = 1L;
        Set<Comment> comments = new HashSet<>();
        when(commentService.getComments(taskId)).thenReturn(comments);

        mockMvc.perform(get("/comments/tasks/{taskId}", taskId))
                .andExpect(status().isOk());

        verify(commentService).getComments(taskId);
    }

    @Test
    void createComment() throws Exception {
        Long taskId = 1L;
        CommentPostDto commentPostDto = new CommentPostDto();
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/comments/tasks/{taskId}", taskId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(commentPostDto)))
                .andExpect(status().isCreated());

        verify(commentService).save(any(), eq(commentPostDto));
    }

    @Test
    void updateComment() throws Exception {
        Long commentId = 1L;
        UpdateCommentDto updateCommentDto = new UpdateCommentDto();
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(put("/comments/{id}", commentId)
                        .content(mapper.writeValueAsString(updateCommentDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(commentService).updateComment(commentId, updateCommentDto);
    }

    @Test
    void deleteComment() throws Exception {
        Long commentId = 1L;

        mockMvc.perform(delete("/comments/{id}", commentId))
                .andExpect(status().isOk());

        verify(commentService).delete(commentId);
    }
}