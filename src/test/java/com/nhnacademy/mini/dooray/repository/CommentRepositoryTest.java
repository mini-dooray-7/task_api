package com.nhnacademy.mini.dooray.repository;

import com.nhnacademy.mini.dooray.domain.ProjectState;
import com.nhnacademy.mini.dooray.domain.TaskState;
import com.nhnacademy.mini.dooray.entity.Comment;
import com.nhnacademy.mini.dooray.entity.Project;
import com.nhnacademy.mini.dooray.entity.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
class CommentRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CommentRepository commentRepository;

    @Test
    void testGetCommentsByTaskId() {
        Long projectId = 1L;
        Long taskId = 1L;
        Project project = new Project();
        project.setProjectId(projectId);
        project.setProjectName("Sample Project");
        project.setProjectState(ProjectState.ACTIVE);
        entityManager.merge(project);

        Task task = new Task();
        task.setTaskId(taskId);
        task.setTaskTitle("Sample Task");
        task.setTaskContent("Sample Task Content");
        task.setTaskCreatedAt(LocalDateTime.now());
        task.setState(TaskState.ACTIVE);
        task.setProject(project);
        entityManager.merge(task);

        Comment comment1 = new Comment();
        comment1.setCommentId(1L);
        comment1.setTask(task);
        comment1.setCommentContent("Comment 1");
        entityManager.merge(comment1);

        Comment comment2 = new Comment();
        comment2.setCommentId(2L);
        comment2.setTask(task);
        comment2.setCommentContent("Comment 2");
        entityManager.merge(comment2);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        task.setComments(comments);
        entityManager.flush();
        List<Comment> fetchedComments = commentRepository.findAllByTask_TaskId(taskId);

        assertEquals(2, fetchedComments.size());
        assertEquals("Comment 1", fetchedComments.get(0).getCommentContent());
        assertEquals("Comment 2", fetchedComments.get(1).getCommentContent());

    }

    @Test
    void testGetComments() {
        Long projectId = 1L;
        Long taskId = 1L;
        Project project = new Project();
        project.setProjectId(projectId);
        project.setProjectName("Sample Project");
        project.setProjectState(ProjectState.ACTIVE);
        entityManager.merge(project);

        Task task = new Task();
        task.setTaskId(taskId);
        task.setTaskTitle("Sample Task");
        task.setTaskContent("Sample Task Content");
        task.setTaskCreatedAt(LocalDateTime.now());
        task.setState(TaskState.ACTIVE);
        task.setProject(project);
        entityManager.merge(task);

        Comment comment1 = new Comment();
        comment1.setCommentId(1L);
        comment1.setTask(task);
        comment1.setCommentContent("Comment 1");
        entityManager.merge(comment1);

        Comment comment2 = new Comment();
        comment2.setCommentId(2L);
        comment2.setTask(task);
        comment2.setCommentContent("Comment 2");
        entityManager.merge(comment2);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        task.setComments(comments);
        List<Comment> fetchedComments = commentRepository.findAll();

        assertEquals(2, fetchedComments.size());
        assertEquals("Comment 1", fetchedComments.get(0).getCommentContent());
        assertEquals("Comment 2", fetchedComments.get(1).getCommentContent());

    }

    @Test
    void testGetCommentById() {
        Long projectId = 1L;
        Long taskId = 1L;
        Project project = new Project();
        project.setProjectId(projectId);
        project.setProjectName("Sample Project");
        project.setProjectState(ProjectState.ACTIVE);
        entityManager.merge(project);

        Task task = new Task();
        task.setTaskId(taskId);
        task.setTaskTitle("Sample Task");
        task.setTaskContent("Sample Task Content");
        task.setTaskCreatedAt(LocalDateTime.now());
        task.setState(TaskState.ACTIVE);
        task.setProject(project);
        entityManager.merge(task);

        Comment comment1 = new Comment();
        comment1.setCommentId(1L);
        comment1.setTask(task);
        comment1.setCommentContent("Comment 1");
        entityManager.merge(comment1);

        Comment comment2 = new Comment();
        comment2.setCommentId(2L);
        comment2.setTask(task);
        comment2.setCommentContent("Comment 2");
        entityManager.merge(comment2);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        task.setComments(comments);
        Optional<Comment> fetchedComment = commentRepository.findById(1L);

        assertThat(fetchedComment).isPresent();
        assertThat(fetchedComment.get().getCommentId()).isEqualTo(1L);
    }

    @Test
    void testSave() {
        Long projectId = 1L;
        Long taskId = 1L;
        Project project = new Project();
        project.setProjectId(projectId);
        project.setProjectName("Sample Project");
        project.setProjectState(ProjectState.ACTIVE);
        entityManager.merge(project);

        Task task = new Task();
        task.setTaskId(taskId);
        task.setTaskTitle("Sample Task");
        task.setTaskContent("Sample Task Content");
        task.setTaskCreatedAt(LocalDateTime.now());
        task.setState(TaskState.ACTIVE);
        task.setProject(project);
        entityManager.merge(task);

        Comment comment1 = new Comment();
        comment1.setCommentId(1L);
        comment1.setTask(task);
        comment1.setCommentContent("Comment 1");
        entityManager.merge(comment1);

        Comment comment2 = new Comment();
        comment2.setCommentId(2L);
        comment2.setTask(task);
        comment2.setCommentContent("Comment 2");
        entityManager.merge(comment2);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        task.setComments(comments);

        Comment comment3 = new Comment();
        comment3.setCommentId(3L);
        comment3.setTask(task);
        comment3.setCommentContent("Comment 3");

        commentRepository.save(comment3);
        Optional<Comment> comment = commentRepository.findById(3L);

        assertThat(comment).isNotNull();
        assertThat(comment.get().getCommentId()).isEqualTo(3L);
    }

    @Test
    void testDelete() {
        Long projectId = 1L;
        Long taskId = 1L;
        Project project = new Project();
        project.setProjectId(projectId);
        project.setProjectName("Sample Project");
        project.setProjectState(ProjectState.ACTIVE);
        entityManager.merge(project);

        Task task = new Task();
        task.setTaskId(taskId);
        task.setTaskTitle("Sample Task");
        task.setTaskContent("Sample Task Content");
        task.setTaskCreatedAt(LocalDateTime.now());
        task.setState(TaskState.ACTIVE);
        task.setProject(project);
        entityManager.merge(task);

        Comment comment1 = new Comment();
        comment1.setCommentId(1L);
        comment1.setTask(task);
        comment1.setCommentContent("Comment 1");
        entityManager.merge(comment1);

        Comment comment2 = new Comment();
        comment2.setCommentId(2L);
        comment2.setTask(task);
        comment2.setCommentContent("Comment 2");
        entityManager.merge(comment2);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        task.setComments(comments);

        commentRepository.delete(comment2);
        List<Comment> fetchedComments = commentRepository.findAll();

        assertEquals(1, fetchedComments.size());
        assertEquals("Comment 1", fetchedComments.get(0).getCommentContent());
    }

    @Test
    void testUpdate() {
        Long projectId = 1L;
        Long taskId = 1L;
        Project project = new Project();
        project.setProjectId(projectId);
        project.setProjectName("Sample Project");
        project.setProjectState(ProjectState.ACTIVE);
        entityManager.merge(project);

        Task task = new Task();
        task.setTaskId(taskId);
        task.setTaskTitle("Sample Task");
        task.setTaskContent("Sample Task Content");
        task.setTaskCreatedAt(LocalDateTime.now());
        task.setState(TaskState.ACTIVE);
        task.setProject(project);
        entityManager.merge(task);

        Comment comment1 = new Comment();
        comment1.setCommentId(1L);
        comment1.setTask(task);
        comment1.setCommentContent("Comment 1");
        entityManager.merge(comment1);

        Comment comment2 = new Comment();
        comment2.setCommentId(2L);
        comment2.setTask(task);
        comment2.setCommentContent("Comment 2");
        entityManager.merge(comment2);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        task.setComments(comments);

        comment2.setCommentContent("ddddd");
        commentRepository.save(comment2);
        List<Comment> fetchedComments = commentRepository.findAll();

        assertEquals(2, fetchedComments.size());
        assertEquals("ddddd", fetchedComments.get(1).getCommentContent());
    }
}