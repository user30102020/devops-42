package com.example.bshop42.services.impl;

import com.example.bshop42.dto.SignUpForm;
import com.example.bshop42.exceptions.UserAlreadyExistsException;
import com.example.bshop42.model.Role;
import com.example.bshop42.model.User;
import com.example.bshop42.repository.UserRepository;
import com.example.bshop42.security.UserDetailsImpl;
import com.example.bshop42.services.AuthService;

import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpForm form) throws UserAlreadyExistsException {
        if(userRepository.existsByEmail(form.getEmail())) {
            throw new UserAlreadyExistsException("Пользователь уже зарегистрирован");
        }
        User user = User.builder()
                .firstname(form.getFirstname())
                .email(form.getEmail())
                .passwordHash(passwordEncoder.encode(form.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        User user = optionalUser.get();
        return UserDetailsImpl.builder()
                .email(user.getEmail())
                .password(user.getPasswordHash())
                .roles(List.of(user.getRole()))
                .build();
    }
}