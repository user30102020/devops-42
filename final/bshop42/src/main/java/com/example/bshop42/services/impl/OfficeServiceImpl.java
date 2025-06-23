package com.example.bshop42.services.impl;

import com.example.bshop42.dto.OfficeForm;
import com.example.bshop42.model.Office;
import com.example.bshop42.repository.OfficeRepository;
import com.example.bshop42.services.OfficeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OfficeServiceImpl implements OfficeService {
    private OfficeRepository officeRepository;

    @Override
    public void createOffice(OfficeForm form) {
        Office office = Office.builder()
                .name(form.getOffice_name())
                .price(form.getOffice_price())
                .description(form.getOffice_description())
                .build();
        officeRepository.save(office);
    }

    @Override
    public void deleteOffice(UUID id) {
        officeRepository.deleteById(id);
    }

    @Override
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }
}
