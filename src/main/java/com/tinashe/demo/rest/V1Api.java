package com.tinashe.demo.rest;

import com.tinashe.demo.entity.Task;
import com.tinashe.demo.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface V1Api {

    /**
     * will add new user into the persisted store for the user specified in the request
     * @param user
     * @return
     *           204 (Successfully added new user.)
     *           400 (could not add the user.)
     *           500 (Any server error conditions.)
     */
    ResponseEntity<Void> addUser(User user);

    /**
     * will update existing  user in persisted store.
     * @param userId
     * @param user
     * @return
     *           204 (Successfully added new user.)
     *           400 (could not update the user.)
     *           500 (Any server error conditions.)
     */
    ResponseEntity<Void> updateUser(Long userId, User user);

    /**
     * will fetch user information from persisted storage.
     * @param userId
     * @return
     *           200 (Successfully retrieved user information.)
     *           400 (could not post the favourite)
     *           500 (Any server error conditions.)
     */
    ResponseEntity<User> getUserInformation(Long userId);

    /**
     * will fetch list of users from persisted storage.
     * @return
     *           200 (Successfully retrieved list of users.)
     *           400 (could not get the list.)
     *           500 (Any server error conditions.)
     */
    ResponseEntity<List<User>> ListUsers();

    /**
     * will create a task for a specific user.
     * @param userId
     * @param task
     * @return
     *           200 (Successfully retrieved user information.)
     *           400 (could not update the user)
     *           500 (Any server error conditions.)
     */
    ResponseEntity<Task> createTask(Long userId, Task task);

    /**
     * will update a task for a specific user.
     * @param userId
     * @param taskId
     * @param task
     * @return
     *           204 (Successfully updated a user task.)
     *           400 (could not update the task)
     *           500 (Any server error conditions.)
     */
    ResponseEntity<Task> updateTask(Long userId, Long taskId,Task task);

    /**
     * will delete a task for a specific user.
     * @param taskId
     * @param userId
     * @return
     *           200 (Successfully deleted a user task.)
     *           400 (could not deleted a user task.)
     *           500 (Any server error conditions.)
     */
    ResponseEntity<Void> deleteTask(Long taskId, Long userId);

    /**
     * will fetch user task information from persisted storage.
     * @param userId
     * @param taskId
     * @return
     *           200 (Successfully retrieved user task information.)
     *           400 (could not get the user task information)
     *           500 (Any server error conditions.)
     */
    ResponseEntity<Task> getTaskInformation(Long userId, Long taskId);

    /**
     * will fetch user tasks from persisted storage
     * @param userId
     * @return
     *           200 (Successfully retrieved user information.)
     *           400 (could not get the user tasks)
     *           500 (Any server error conditions.)
     */
    ResponseEntity<List<Task>> getUserTasks(Long userId);

}

