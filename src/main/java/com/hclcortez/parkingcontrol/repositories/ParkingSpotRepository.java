package com.hclcortez.parkingcontrol.repositories;

import com.hclcortez.parkingcontrol.dtos.ParkingSpotDTO;
import com.hclcortez.parkingcontrol.models.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, UUID> {

    boolean existsByLicensePlateCar(String licensePlateCa);

    boolean existsByParkingSpotNumber(String parkingSpotNumber);

    boolean existsByApartmentAndBlock(String apartment, String block);
}
