package com.tinashe.demo.rest;

import com.tinashe.demo.entity.Task;
import com.tinashe.demo.entity.User;
import com.tinashe.demo.service.TaskService;
import com.tinashe.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class V1Controller implements V1Api{


    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;


    @Override
    @PostMapping(path = "/user", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/user/{user_id}", method = RequestMethod.PUT, produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<Void> updateUser(@PathVariable("user_id") Long userId,
                                           @RequestBody User user) {
        user.setId(userId);
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping(path = "/user/{user_id}", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<User> getUserInformation(@PathVariable("user_id") Long userId) {
        return new ResponseEntity<>(userService.getUserInformation(userId), HttpStatus.OK);
    }

    @Override
    @GetMapping(path = "/user", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<User>> ListUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @Override
    @PostMapping(path = "/user/{user_id}/task", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<Task> createTask(@PathVariable("user_id") Long userId,
                                           @RequestParam Task task) {
        taskService.createTask(userId, task);

        return new ResponseEntity<>(taskService.createTask(userId, task), HttpStatus.OK);
    }

    @Override
    @PutMapping(path = "/user/{user_id}/task/{task_id}", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<Task> updateTask(@PathVariable("user_id") Long userId,
                                           @PathVariable("task_id") Long taskId,
                                           @RequestBody Task task) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @DeleteMapping(path = "/user/{user_id}/task/{task_id}", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<Void> deleteTask(@PathVariable("task_id") Long taskId,
                                           @PathVariable("user_id") Long userId) {
        taskService.deleteTaskInformation(taskId, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping(path = "/user/{user_id}/task/{task_id}", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<Task> getTaskInformation(@PathVariable("user_id") Long userId,
                                                   @PathVariable("task_id") Long taskId) {

        return new ResponseEntity<>(taskService.getUserTaskInformation(userId, taskId), HttpStatus.OK);
    }

    @Override
    @GetMapping(path = "/user/{user_id}/task", produces = {
            "application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<Task>> getUserTasks(@PathVariable("user_id") Long userId) {

        return new ResponseEntity<>(taskService.getAllUserTasks(userId), HttpStatus.OK);
    }
}
