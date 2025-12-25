package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    public static final String STATUS_CONFIRMED = "CONFIRMED";
    public static final String STATUS_CANCELLED = "CANCELLED";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "start_time")
    private LocalDateTime startTime;
    
    @Column(name = "end_time")
    private LocalDateTime endTime;
    
    private String status = STATUS_CONFIRMED;

    public Booking() {}

    public Booking(Long id, Facility facility, User user,
                   LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.id = id;
        this.facility = facility;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status == null ? STATUS_CONFIRMED : status;
    }

    // getters & setters
    public Long getId() { return id; }
    public Facility getFacility() { return facility; }
    public User getUser() { return user; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void setId(Long id) { this.id = id; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
}
