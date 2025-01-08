package org.example.backend.services;

import org.example.backend.entities.User;
import org.example.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void updateProfilePhoto(Long userId, String photoBase64) {
        userRepository.findById(userId).ifPresent(user -> {
            user.setProfilePhoto(photoBase64);
            userRepository.save(user);
        });
    }
}
