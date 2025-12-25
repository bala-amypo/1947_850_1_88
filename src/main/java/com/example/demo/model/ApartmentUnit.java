package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String unitNumber;

    @Column(nullable = false)
    private Integer floor;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    // Constructors
    public ApartmentUnit() {}
    public ApartmentUnit(String unitNumber, Integer floor, User owner) {
        this.unitNumber = unitNumber;
        this.floor = floor;
        this.owner = owner;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUnitNumber() { return unitNumber; }
    public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }

    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
