package com.example.bshop42.services.impl;

import com.example.bshop42.model.Workplace;
import com.example.bshop42.repository.WorkplaceRepository;
import com.example.bshop42.services.WorkplaceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkplaceServiceImpl implements WorkplaceService {
    private final WorkplaceRepository workplaceRepository;

    @Override
    public List<Workplace> getAllWorkplaces() {
        return workplaceRepository.findAll();
    }
}
