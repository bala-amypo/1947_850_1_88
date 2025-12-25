package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apartment_units")
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "unit_number")
    private String unitNumber;
    
    private int floor;
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public ApartmentUnit() {}

    public ApartmentUnit(Long id, String unitNumber, int floor, User owner) {
        this.id = id;
        this.unitNumber = unitNumber;
        this.floor = floor;
        this.owner = owner;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUnitNumber() { return unitNumber; }
    public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }

    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
