package com.BOA_UserManagement.Services;

import com.BOA_UserManagement.Services.Interfaces.UserService;
import com.BOA_UserManagement.Model.User;
import com.BOA_UserManagement.Repositories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        log.info("Creating new user: {}", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        log.info("Fetching user with ID: {}", userId);
        return userRepository.findById(userId);
    }

    @Override
    public User updateUser(Long userId, User user) {
        log.info("Updating user with ID: {}", userId);
        if (userRepository.existsById(userId)) {
            user.setId(userId);
            return userRepository.save(user);
        }
        log.error("User with ID {} not found", userId);
        return null;
    }

    @Override
    public boolean deleteUser(Long userId) {
        log.info("Deleting user with ID: {}", userId);
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        log.error("User with ID {} not found", userId);
        return false;
    }
}
