package com.hclcortez.parkingcontrol.services;


import com.hclcortez.parkingcontrol.models.ParkingSpot;
import com.hclcortez.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeleteParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public DeleteParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }


    @Transactional
    public void exec(ParkingSpot parkingSpot){
        this.parkingSpotRepository.delete(parkingSpot);
    }
}
