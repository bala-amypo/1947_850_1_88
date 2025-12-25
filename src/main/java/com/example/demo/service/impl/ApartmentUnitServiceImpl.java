package com.example.demo.service.impl;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository unitRepository;
    private final UserRepository userRepository;
    
    public ApartmentUnitServiceImpl(ApartmentUnitRepository unitRepository, UserRepository userRepository) {
        this.unitRepository = unitRepository;
        this.userRepository = userRepository;
    }

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
    
    @Override
    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
        User user = userRepository.findById(userId).orElseThrow();
        unit.setOwner(user);
        return unitRepository.save(unit);
    }
    
    @Override
    public ApartmentUnit getUnitByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return unitRepository.findByOwner(user).orElse(null);
    }
}
