package com.example.demo.service.impl;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    @Autowired
    private ApartmentUnitRepository unitRepository;

    @Override
    public ApartmentUnit saveUnit(ApartmentUnit unit) {
        return unitRepository.save(unit);
    }

    @Override
    public List<ApartmentUnit> getAllUnits() {
        return unitRepository.findAll();
    }

    @Override
    public ApartmentUnit getUnitById(Long id) {
        Optional<ApartmentUnit> optional = unitRepository.findById(id);
        return optional.orElse(null);
    }
}
