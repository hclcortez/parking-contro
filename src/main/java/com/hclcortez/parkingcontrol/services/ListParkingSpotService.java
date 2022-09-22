package com.hclcortez.parkingcontrol.services;

import com.hclcortez.parkingcontrol.models.ParkingSpot;
import com.hclcortez.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ListParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public List<ParkingSpot> exec(){
         return this.parkingSpotRepository.findAll();
    }

}
