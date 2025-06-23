package com.example.bshop42.services;

import com.example.bshop42.model.User;

import java.util.Optional;

public interface UserService {
    void saveUser(User user);

    User getUserByEmail(String email);
}
