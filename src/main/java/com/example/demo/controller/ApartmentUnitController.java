package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping("/units")
public class ApartmentUnitController {

    @Autowired
    private ApartmentUnitService apartmentUnitService;

    @PostMapping
    
    public ApartmentUnit createUnit(@RequestBody ApartmentUnit unit) {
        return apartmentUnitService.saveUnit(unit);
    }

    @GetMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public List<ApartmentUnit> getAllUnits() {
        return apartmentUnitService.getAllUnits();
    }

    @PutMapping("/assign/{unitId}/{userId}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ApartmentUnit assignUnit(
            @PathVariable Long unitId,
            @PathVariable Long userId) {

        return apartmentUnitService.assignUnitToUser(unitId, userId);
    }
}
