package com.example.bshop42.services;


import com.example.bshop42.dto.SignUpForm;

import com.example.bshop42.exceptions.UserAlreadyExistsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface AuthService extends UserDetailsService {

    void signUp(SignUpForm form) throws UserAlreadyExistsException;
}