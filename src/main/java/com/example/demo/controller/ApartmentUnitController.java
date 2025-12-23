package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.service.ApartmentUnitService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    @Autowired
    private ApartmentUnitService unitService;

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<ApartmentUnit> createUnit(@RequestBody ApartmentUnit unit) {
        ApartmentUnit savedUnit = unitService.saveUnit(unit);
        return ResponseEntity.ok(savedUnit);
    }

    @GetMapping
    public ResponseEntity<List<ApartmentUnit>> getAllUnits() {
        List<ApartmentUnit> units = unitService.getAllUnits();
        return ResponseEntity.ok(units);
    }
    @PutMapping("/assign/{userId}/{unitId}")
    public ResponseEntity<ApartmentUnit> assignUnitToUser(
            @PathVariable Long userId,
            @PathVariable Long unitId
    ) {
        User user = userService.findById(userId);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        ApartmentUnit unit = unitService.getUnitById(unitId);
        if (unit == null) {
            return ResponseEntity.badRequest().build();
        }

        unit.setOwner(user);
        ApartmentUnit updatedUnit = unitService.saveUnit(unit);

        return ResponseEntity.ok(updatedUnit);
    }
}
