package com.example.UberProject_EntityService.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes={
        @Index(columnList = "driver_id")
})
public class Booking extends BaseModel {

    @Enumerated(value= EnumType.STRING)
    private BookingStatus bookingStatus;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long totalDistance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;

    @OneToOne(cascade = CascadeType.ALL)
    private ExactLocation startLocation;

    @OneToOne(cascade = CascadeType.ALL)
    private ExactLocation endLocation;
}

