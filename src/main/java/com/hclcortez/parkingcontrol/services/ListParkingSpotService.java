package com.hclcortez.parkingcontrol.services;

import com.hclcortez.parkingcontrol.models.ParkingSpot;
import com.hclcortez.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ListParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Page<ParkingSpot> exec(Pageable pageable){
         return this.parkingSpotRepository.findAll(pageable);
    }

}
