package com.example.bshop42.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/panel")
    String getAdminPanel() {
        return "adm_panel";
    }
}
