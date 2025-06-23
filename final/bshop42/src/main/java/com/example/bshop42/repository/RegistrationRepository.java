package com.example.bshop42.repository;

import com.example.bshop42.model.Registration;
import com.example.bshop42.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface RegistrationRepository extends JpaRepository<Registration, UUID> {
    List<Registration> getAllByUser(User user);
}
