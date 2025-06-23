package com.example.bshop42.controllers;

import com.example.bshop42.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class ConnectionTestController {

    private final UserRepository userRepository;

    public ConnectionTestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/db")
    public ResponseEntity<String> testDbConnection() {
        try {
            long count = userRepository.count(); // простой запрос
            return ResponseEntity.ok("✅ Соединение с БД установлено. Кол-во пользователей: " + count);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("❌ Ошибка соединения с БД: " + e.getMessage());
        }
    }
}
