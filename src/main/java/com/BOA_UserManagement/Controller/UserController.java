package com.BOA_UserManagement.Controller;

import com.BOA_UserManagement.Model.User;
import com.BOA_UserManagement.Services.Interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor


public class UserController {
    private final UserService userService;
    // Create User Profile
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Create user by calling service
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Retrieve All User Profiles
    @GetMapping
    public List<User> getAllUsers() {
        // Fetch all users
        return userService.getAllUsers();
    }

    // Retrieve User by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        // Retrieve user by ID from the service
        Optional<User> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update User Profile
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        // Update user by calling the service
        User updatedUser = userService.updateUser(userId, user);
        return updatedUser != null ? ResponseEntity.ok(updatedUser)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete User Profile
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        // Delete user by calling service
        return userService.deleteUser(userId) ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
