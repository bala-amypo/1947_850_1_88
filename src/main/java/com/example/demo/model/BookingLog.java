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
    @JoinColumn(name = "booking_id")
    private Booking booking;
    
    @Column(name = "log_message")
    private String logMessage;
    
    @Column(name = "logged_at")
    private LocalDateTime loggedAt;

    public BookingLog() {}

    public BookingLog(Long id, Booking booking, String logMessage, LocalDateTime loggedAt) {
        this.id = id;
        this.booking = booking;
        this.logMessage = logMessage;
        this.loggedAt = loggedAt;
    }

    @PrePersist
    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getLogMessage() { return logMessage; }
    public Booking getBooking() { return booking; }
    public LocalDateTime getLoggedAt() { return loggedAt; }
    public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setLogMessage(String message) {
        this.logMessage = message;
    }
}
