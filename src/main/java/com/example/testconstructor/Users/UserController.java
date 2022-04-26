package com.example.testconstructor.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    ResponseEntity<User> findUser(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllTests() {
        return userService.findAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long userId, String userName, Long testId, Integer rightQuestionAmount) {
        return userService.updateUser(userId, userName, testId, rightQuestionAmount);
    }

}
