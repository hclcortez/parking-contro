package com.hclcortez.parkingcontrol.services;

import com.hclcortez.parkingcontrol.models.ParkingSpot;
import com.hclcortez.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UpdateParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public UpdateParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpot exec(ParkingSpot parkingSpot){
        return this.parkingSpotRepository.save(parkingSpot);
    }
}
