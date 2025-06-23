package com.example.bshop42.repository;

import com.example.bshop42.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfficeRepository extends JpaRepository<Office, UUID> {
}
