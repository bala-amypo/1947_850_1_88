package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking_logs")
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Booking booking;

    private String logMessage;
    private LocalDateTime loggedAt;

    public BookingLog() {}

    @PrePersist
    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    public void setBooking(Booking booking) { this.booking = booking; }
    public void setLogMessage(String logMessage) { this.logMessage = logMessage; }
}
