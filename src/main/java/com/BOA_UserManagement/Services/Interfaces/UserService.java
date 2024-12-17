package com.BOA_UserManagement.Services.Interfaces;

import com.BOA_UserManagement.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // Create a new user
    User createUser(User user);

    // Get all users
    List<User> getAllUsers();

    // Get user by ID
    Optional<User> getUserById(Long userId);

    // Update an existing user
    User updateUser(Long userId, User user);

    // Delete a user by ID
    boolean deleteUser(Long userId);
}
