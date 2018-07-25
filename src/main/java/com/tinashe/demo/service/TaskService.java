package com.tinashe.demo.service;

import com.tinashe.demo.entity.Task;

import java.util.List;

public interface TaskService {

    Task getUserTaskInformation(Long userId, Long taskId);

    Task updateTask(Long taskId, Long userId, Task task);

    Void deleteTaskInformation(Long taskId, Long userId);

    Task createTask(Long userId, Task task);

    List<Task> getAllUserTasks(Long userId);

}
