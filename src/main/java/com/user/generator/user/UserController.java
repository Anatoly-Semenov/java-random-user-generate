package com.user.generator.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping(path = "{id}")
    public Optional<User> getUserDetail(@PathVariable("id") Long id) {
        return this.userService.getUserDetail(id);
    }

    @GetMapping(path = "generate")
    public Optional<User> generateRandomUser() {
        return this.userService.generateRandomUser();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return this.userService.createUser(newUser);
    }

    @DeleteMapping(path = "{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return this.userService.deleteUserById(id);
    }
}
