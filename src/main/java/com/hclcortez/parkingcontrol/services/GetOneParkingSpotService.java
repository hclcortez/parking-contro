package com.hclcortez.parkingcontrol.services;

import com.hclcortez.parkingcontrol.models.ParkingSpot;
import com.hclcortez.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetOneParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public GetOneParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Optional<ParkingSpot> exec(UUID id){
        return this.parkingSpotRepository.findById(id);
    }

}
