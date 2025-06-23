package com.example.bshop42.controllers;

import com.example.bshop42.dto.OfficeForm;
import com.example.bshop42.dto.RegForm;
import com.example.bshop42.model.Office;
import com.example.bshop42.services.impl.OfficeServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class OfficeController {
    private final OfficeServiceImpl officeService;
    @GetMapping("/offices")
    String getOffices(Model model) {
        List<Office> offices = officeService.getAllOffices();
        model.addAttribute("offices", offices);

        return "offices";
    }

    @GetMapping("/admin/offices")
    String getAdminOffices(Model model) {
        List<Office> offices = officeService.getAllOffices();
        model.addAttribute("offices", offices);

        return "adm_offices";
    }

    @PostMapping("/admin/offices/delete/{office_id}")
    String deleteOffice(@PathVariable UUID office_id) {
        officeService.deleteOffice(office_id);
        return "redirect:/admin/offices";
    }

    @PostMapping("/admin/offices")
    String addOffice(@ModelAttribute @Valid OfficeForm officeForm) {
        officeService.createOffice(officeForm);
        return "redirect:/admin/offices";
    }
}
