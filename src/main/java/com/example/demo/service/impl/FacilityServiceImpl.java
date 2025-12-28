package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository repo;

    public FacilityServiceImpl(FacilityRepository repo) {
        this.repo = repo;
    }

    @Override
    public Facility addFacility(Facility f) {
        // Validate inputs
        if (f.getName() == null || f.getName().trim().isEmpty()) {
            throw new BadRequestException("Facility name cannot be empty");
        }
        if (f.getOpenTime() == null || f.getCloseTime() == null) {
            throw new BadRequestException("Facility times cannot be null");
        }
        
        // Check for duplicate name
        if (repo.findByName(f.getName()).isPresent()) {
            throw new BadRequestException("Facility with this name already exists");
        }
        
        // Validate time range
        if (f.getOpenTime().compareTo(f.getCloseTime()) >= 0)
            throw new BadRequestException("Invalid time");
        
        return repo.save(f);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return repo.findAll();
    }
}
