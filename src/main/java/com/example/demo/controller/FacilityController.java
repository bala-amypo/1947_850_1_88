package com.example.demo.controller;

import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/facilities")
@Tag(name = "Facility", description = "Facility Management")
public class FacilityController {
    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createFacility(@RequestBody Facility facility) {
        Facility created = facilityService.addFacility(facility);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllFacilities() {
        List<Facility> facilities = facilityService.getAllFacilities();
        return ResponseEntity.ok(facilities);
    }
}
