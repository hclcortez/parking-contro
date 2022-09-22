package com.hclcortez.parkingcontrol.controllers;

import com.hclcortez.parkingcontrol.models.ParkingSpot;
import com.hclcortez.parkingcontrol.services.GetOneParkingSpotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class GetOneParkingSpotController {

    final GetOneParkingSpotService getOneParkingSpotService;

    public GetOneParkingSpotController(GetOneParkingSpotService getOneParkingSpotService) {
        this.getOneParkingSpotService = getOneParkingSpotService;
    }

    @GetMapping("parking-spot/{id}")
    public ResponseEntity<Object> handle(@PathVariable(value = "id") UUID id){
    Optional<ParkingSpot> parkingSpotOptional = this.getOneParkingSpotService.exec(id);

    if(!parkingSpotOptional.isPresent()){
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot not found");
    }
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotOptional.get());
    }
}
