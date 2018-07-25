package com.tinashe.demo.manager;

import com.tinashe.demo.dao.TaskRepository;
import com.tinashe.demo.dao.UserRepository;
import com.tinashe.demo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class TaskManagerImpl implements TaskManager {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task getUserTaskInformation(Long userId, Long taskId) {
        return taskRepository.findByUserIdAndTaskId(userId, taskId);
    }

    @Override
    public Task updateTask(Long taskId, Long userId, Task task) {
        Task updatedTask = taskRepository.findByUserIdAndTaskId(userId, taskId);

        LocalDate localDate = LocalDate.now();
        updatedTask.setDateTime(localDate);
        updatedTask.setName(task.getName());
        updatedTask.setUserId(userId);
        updatedTask.setDescription(task.getDescription());
        taskRepository.save(task);

        return updatedTask;
    }

    @Override
    public List<Task> getAllUserTasks(Long userId) {
        return taskRepository.findAllByUserId(userId);
    }

    @Override
    public Void deleteTaskInformation(Long taskId, Long userId) {
        taskRepository.deleteByTaskIdAndUserId(taskId, userId);
        return null;
    }

    @Override
    public Task createTask(Long userId, Task task) {
        task.setUserId(userId);
        taskRepository.save(task);
        //get task and return it.

        return  taskRepository.findByUserIdAndTaskId(userId, task.getId());
    }
}
