package com.example.bshop42.services.impl;

import com.example.bshop42.dto.BarberForm;
import com.example.bshop42.model.Barber;
import com.example.bshop42.repository.BarberRepository;
import com.example.bshop42.repository.WorkplaceRepository;
import com.example.bshop42.services.BarberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BarberServiceImpl implements BarberService {
    private BarberRepository barberRepository;
    private WorkplaceRepository workplaceRepository;

    @Override
    public void createBarber(BarberForm form) {
        Barber barber = Barber.builder()
                .name(form.getBarber_name())
                .experience(form.getBarber_experience())
                .workplace(workplaceRepository.findById(form.getWorkplace_id()).orElseThrow())
                .build();
        barberRepository.save(barber);
    }

    @Override
    public List<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }

    @Override
    public void deleteBarber(Barber barber) {
        barberRepository.delete(barber);
    }

    @Override
    public Barber getBarberById(UUID id) {
        return barberRepository.findById(id).orElseThrow();
    }
}
