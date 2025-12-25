package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/units")
@Tag(name = "ApartmentUnit", description = "Apartment Unit Management")
public class ApartmentUnitController {
    private final ApartmentUnitService apartmentUnitService;

    public ApartmentUnitController(ApartmentUnitService apartmentUnitService) {
        this.apartmentUnitService = apartmentUnitService;
    }

    @PostMapping("/assign/{userId}")
    public ResponseEntity<?> assignUnit(@PathVariable Long userId,
                                        @RequestBody ApartmentUnit unit) {
        ApartmentUnit assigned = apartmentUnitService.assignUnitToUser(userId, unit);
        return ResponseEntity.status(HttpStatus.CREATED).body(assigned);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserUnit(@PathVariable Long userId) {
        ApartmentUnit unit = apartmentUnitService.getUnitByUser(userId);
        return ResponseEntity.ok(unit);
    }
}
