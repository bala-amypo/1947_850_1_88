package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.service.BookingLogService;
import com.example.demo.repository.BookingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class BookingLogController {

    private final BookingLogService bookingLogService;
    private final BookingRepository bookingRepository;

    public BookingLogController(BookingLogService bookingLogService,
                                BookingRepository bookingRepository) {
        this.bookingLogService = bookingLogService;
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<BookingLog>> getLogsByBooking(
            @PathVariable Long bookingId) {

        // Fetch the Booking object first
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> 
                        new RuntimeException("Booking not found"));

        // Pass the Booking object to the service
        List<BookingLog> logs = bookingLogService.getLogsByBooking(booking);

        return ResponseEntity.ok(logs);
    }
}
