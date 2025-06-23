package com.example.bshop42.controllers;

import com.example.bshop42.dto.RegForm;
import com.example.bshop42.model.*;
import com.example.bshop42.repository.UserRepository;
import com.example.bshop42.repository.WorkplaceRepository;
import com.example.bshop42.security.UserDetailsImpl;
import com.example.bshop42.services.UserService;
import com.example.bshop42.services.impl.BarberServiceImpl;
import com.example.bshop42.services.impl.OfficeServiceImpl;
import com.example.bshop42.services.impl.RegServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private final UserService userService;
    private final RegServiceImpl regService;
    private final BarberServiceImpl barberService;
    private final WorkplaceRepository workplaceRepository;
    private final OfficeServiceImpl officeService;

    @GetMapping("/main")
    String getMainPage(Model model) {
        List<Office> offices = officeService.getAllOffices();
        List<Workplace> workplaces = workplaceRepository.findAll();
        List<Barber> barbers = barberService.getAllBarbers();

        model.addAttribute("offices", offices);
        model.addAttribute("workplaces", workplaces);
        model.addAttribute("barbers", barbers);

        return "main";
    }

    @PostMapping("/main")
    String handleMainPage(@ModelAttribute @Valid RegForm form, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        regService.saveReg(form, userDetails.getUsername());
        return "redirect:/registrations";
    }

    @GetMapping("/registrations")
    String getRegistrationsPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userService.getUserByEmail(userDetails.getUsername());
        List<Registration> userRegs = regService.getRegsByUser(user);

        List<Registration> expiredRegs = regService.getExpiredRegs(userRegs);
        List<Registration> activeRegs = regService.getActiveRegs(userRegs);

        model.addAttribute("expiredRegs", expiredRegs);
        model.addAttribute("activeRegs", activeRegs);

        return "registrations";
    }

    @PostMapping("/registrations/cancel/{registration_id}")
    String cancelActiveRegistration(@PathVariable UUID registration_id) {
        regService.deleteReg(registration_id);
        return "redirect:/registrations";
    }

    @GetMapping("/admin/registrations")
    String getAdminRegistrations(Model model) {
        List<Registration> regs = regService.getAllRegs();
        model.addAttribute("regs", regs);
        return "adm_registrations";
    }

    @PostMapping("/admin/registrations/delete/{registration_id}")
    String deleteAdminRegistration(@PathVariable UUID registration_id) {
        regService.deleteReg(registration_id);
        return "redirect:/admin/registrations";
    }
}
