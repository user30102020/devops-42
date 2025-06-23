package com.example.bshop42.services.impl;

import com.example.bshop42.model.User;
import com.example.bshop42.repository.UserRepository;
import com.example.bshop42.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String name) {
        return userRepository.findByEmail(name).orElseThrow(() -> new RuntimeException());
    }
}
