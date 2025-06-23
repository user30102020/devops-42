package com.example.bshop42.repository;

import com.example.bshop42.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BarberRepository extends JpaRepository<Barber, UUID> {
    Optional<Barber> findById(UUID id);
}
