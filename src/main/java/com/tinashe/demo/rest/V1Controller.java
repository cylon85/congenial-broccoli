package com.tinashe.demo.rest;

import com.tinashe.demo.entity.Task;
import com.tinashe.demo.entity.User;
import com.tinashe.demo.manager.TaskManager;
import com.tinashe.demo.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class V1Controller implements V1Api{


    @Autowired
    TaskManager taskManager;

    @Autowired
    UserManager userManager;


    @Override
    @PostMapping(path = "/user", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userManager.createUser(user), HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/user/{user_id}", method = RequestMethod.PUT, produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<Void> updateUser(@PathVariable("user_id") Long userId,
                                           @RequestBody User user) {
        user.setId(userId);
        userManager.updateUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping(path = "/user/{user_id}", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<User> getUserInformation(@PathVariable("user_id") Long userId) {
        return new ResponseEntity<>(userManager.getUserInformation(userId), HttpStatus.OK);
    }

    @Override
    @GetMapping(path = "/user", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<User>> ListUsers() {
        return new ResponseEntity<>(userManager.findAllUsers(), HttpStatus.OK);
    }

    @Override
    @PostMapping(path = "/user/{user_id}/task", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<Task> createTask(@PathVariable("user_id") Long userId,
                                           @RequestParam Task task) {
        taskManager.createTask(userId, task);

        return new ResponseEntity<>(taskManager.createTask(userId, task), HttpStatus.OK);
    }

    @Override
    @PutMapping(path = "/user/{user_id}/task/{task_id}", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<Task> updateTask(@PathVariable("user_id") Long userId,
                                           @PathVariable("task_id") Long taskId,
                                           @RequestBody Task task) {

        return new ResponseEntity<>(taskManager.updateTask(userId, taskId, task), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(path = "/user/{user_id}/task/{task_id}", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<Void> deleteTask(@PathVariable("task_id") Long taskId,
                                           @PathVariable("user_id") Long userId) {
        taskManager.deleteTaskInformation(taskId, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping(path = "/user/{user_id}/task/{task_id}", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<Task> getTaskInformation(@PathVariable("user_id") Long userId,
                                                   @PathVariable("task_id") Long taskId) {

        return new ResponseEntity<>(taskManager.getUserTaskInformation(userId, taskId), HttpStatus.OK);
    }

    @Override
    @GetMapping(path = "/user/{user_id}/task", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<Task>> getUserTasks(@PathVariable("user_id") Long userId) {

        return new ResponseEntity<>(taskManager.getAllUserTasks(userId), HttpStatus.OK);
    }
}
