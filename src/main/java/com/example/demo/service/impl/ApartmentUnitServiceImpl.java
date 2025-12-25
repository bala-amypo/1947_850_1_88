package com.example.demo.service.impl;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ✅ THIS IS THE FIX
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    @Autowired
    private ApartmentUnitRepository apartmentUnitRepository;

    @Autowired
    private UserRepository userRepository;
    
    public ApartmentUnitServiceImpl() {}
    
    public ApartmentUnitServiceImpl(ApartmentUnitRepository apartmentUnitRepository, UserRepository userRepository) {
        this.apartmentUnitRepository = apartmentUnitRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApartmentUnit saveUnit(ApartmentUnit unit) {
        return apartmentUnitRepository.save(unit);
    }

    @Override
    public List<ApartmentUnit> getAllUnits() {
        return apartmentUnitRepository.findAll();
    }

    @Override
    public ApartmentUnit assignUnitToUser(Long unitId, Long userId) {

        ApartmentUnit unit = apartmentUnitRepository.findById(unitId)
                .orElseThrow(() -> new RuntimeException("Unit not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        unit.setOwner(user);
        return apartmentUnitRepository.save(unit);
    }
    
    @Override
    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        unit.setOwner(user);
        return apartmentUnitRepository.save(unit);
    }
    
    @Override
    public ApartmentUnit getUnitByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        return apartmentUnitRepository.findByOwner(user).orElse(null);
    }
}
