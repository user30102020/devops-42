package com.example.bshop42.controllers;

import com.example.bshop42.dto.SignUpForm;
import com.example.bshop42.exceptions.UserAlreadyExistsException;
import com.example.bshop42.services.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/sign-in")
    String signInView(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);
        return "sign_in";
    }

    @GetMapping("/sign-up")
    String signUpView(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);
        return "sign_up";
    }

    @PostMapping("/sign-up")
    String signUp(@ModelAttribute @Valid SignUpForm form) throws UserAlreadyExistsException {
        authService.signUp(form);
        return "redirect:/main";
    }
}
