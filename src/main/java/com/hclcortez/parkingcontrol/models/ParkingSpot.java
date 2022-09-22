package com.hclcortez.parkingcontrol.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "parking_spots")
public class ParkingSpot implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false, unique = false, length = 10)
  private String parkingSpotNumber;

  @Column(nullable = false, unique = false, length = 7)
  private String licensePlateCar;

  @Column(nullable = false, length = 70)
  private String brandCar;

  @Column(nullable = false, length = 70)
  private String modelCar;

  @Column(nullable = false, length = 73)
  private String colorCar;

  @Column(nullable = false)
  private LocalDateTime registerDate;

  @Column(nullable = true, length = 130)
  private String responsibleName;

  @Column(nullable = true, length = 130)
  private String apartment;

  @Column(nullable = true, length = 130)
  private String block;
}
