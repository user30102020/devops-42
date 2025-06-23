package com.example.bshop42.services;

import com.example.bshop42.dto.BarberForm;
import com.example.bshop42.model.Barber;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BarberService {
    void createBarber(BarberForm form);
    List<Barber> getAllBarbers();

    void deleteBarber(Barber barber);

    Barber getBarberById(UUID id);
}
