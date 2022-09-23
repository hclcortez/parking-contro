package com.hclcortez.parkingcontrol.services;

import com.hclcortez.parkingcontrol.dtos.ParkingSpotDTO;
import com.hclcortez.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomValidationParkingSpot {

    final ParkingSpotRepository parkingSpotRepository;

    public CustomValidationParkingSpot(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public boolean existsByLicensePlateCar(String licensePlateCa){
        return  this.parkingSpotRepository.existsByLicensePlateCar(licensePlateCa);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber){
        return  this.parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block){
        return  this.parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }
}
