package com.example.bshop42.services;

import com.example.bshop42.dto.OfficeForm;
import com.example.bshop42.model.Office;

import java.util.List;
import java.util.UUID;

public interface OfficeService {
    void createOffice(OfficeForm form);
    void deleteOffice(UUID id);
    List<Office> getAllOffices();
}
