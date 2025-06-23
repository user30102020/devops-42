package com.example.bshop42.repository;

import com.example.bshop42.model.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkplaceRepository extends JpaRepository<Workplace, UUID> {
}
