package com.tinashe.demo.dao;

import com.tinashe.demo.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    Task save(Task task);

    void deleteByTaskIdAndUserId(@Param("task_id") Long taskId, @Param("user_id") Long userId);

    Task findByUserIdAndTaskId(@Param("user_id") Long userId, @Param("task_id") Long taskId);

    List<Task> findAllByUserId(@Param("user_id") Long userId);
}
