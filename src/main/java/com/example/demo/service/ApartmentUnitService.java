package com.example.demo.service;

import com.example.demo.model.ApartmentUnit;
import java.util.List;

public interface ApartmentUnitService {

    ApartmentUnit saveUnit(ApartmentUnit unit);

    List<ApartmentUnit> getAllUnits();

    ApartmentUnit assignUnitToUser(Long unitId, Long userId);
    
    ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit);
    
    ApartmentUnit getUnitByUser(Long userId);
}
