package com.example.UberProject_EntityService.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel {
    private String name;

    @Column(nullable = false,unique = true)
    private String licenseNumber;

    private String phoneNumber;

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    private Car car;

    @Enumerated(value=EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;

    private String activeCity;

    @DecimalMin(value="0.00",message = "Rating must be greater than or equal to 0.00")
    @DecimalMax(value = "5.00",message = "Rating must be less than or equal to 5.00")
    private double rating;

    @Column(nullable = false)
    private boolean isAvailable;

    @OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)
    private List<Booking> bookings;
}
