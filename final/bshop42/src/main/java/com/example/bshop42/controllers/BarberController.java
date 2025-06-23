package com.example.bshop42.controllers;

import com.example.bshop42.dto.BarberForm;
import com.example.bshop42.model.Barber;
import com.example.bshop42.model.Workplace;
import com.example.bshop42.services.impl.BarberServiceImpl;
import com.example.bshop42.services.impl.WorkplaceServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class BarberController {
    private final BarberServiceImpl barberService;
    private final WorkplaceServiceImpl workplaceService;

    @GetMapping("/barbers")
    String getBarbersPage(Model model) {
        List<Barber> barbers = barberService.getAllBarbers();
        model.addAttribute("barbers", barbers);
        return "barbers";
    }

    @GetMapping("/admin/barbers")
    String getAdminBarbers(Model model) {
        List<Barber> barbers = barberService.getAllBarbers();
        List<Workplace> workplaces = workplaceService.getAllWorkplaces();
        model.addAttribute("barbers", barbers);
        model.addAttribute("workplaces", workplaces);
        return "adm_barbers";
    }

    @PostMapping("/admin/barbers/delete/{barber_id}")
    String deleteBarber(@PathVariable UUID barber_id) {
        barberService.deleteBarber(barberService.getBarberById(barber_id));
        return "redirect:/admin/barbers";
    }

    @PostMapping("/admin/barbers")
    String addBarber(@ModelAttribute @Valid BarberForm barberForm) {
        barberService.createBarber(barberForm);
        return "redirect:/admin/barbers";
    }
}
