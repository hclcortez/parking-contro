package com.hclcortez.parkingcontrol.services;

import com.hclcortez.parkingcontrol.models.ParkingSpot;
import com.hclcortez.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public CreateParkingSpotService(ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingSpot exec(ParkingSpot parkingSpot){
        return this.parkingSpotRepository.save(parkingSpot);
    };

}
