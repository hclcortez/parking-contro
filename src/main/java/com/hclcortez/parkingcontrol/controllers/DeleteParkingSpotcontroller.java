package com.hclcortez.parkingcontrol.controllers;

import com.hclcortez.parkingcontrol.models.ParkingSpot;
import com.hclcortez.parkingcontrol.services.DeleteParkingSpotService;
import com.hclcortez.parkingcontrol.services.GetOneParkingSpotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class DeleteParkingSpotcontroller {

    final DeleteParkingSpotService deleteParkingSpotService;
    final GetOneParkingSpotService getOneParkingSpotService;

    public DeleteParkingSpotcontroller(DeleteParkingSpotService deleteParkingSpotService, GetOneParkingSpotService getOneParkingSpotService) {
        this.deleteParkingSpotService = deleteParkingSpotService;
        this.getOneParkingSpotService = getOneParkingSpotService;
    }

    @DeleteMapping("parking-spot/{id}")
    public ResponseEntity<Object> handle(@PathVariable(value = "id") UUID id){
        Optional<ParkingSpot> parkingSpotOptional = this.getOneParkingSpotService.exec(id);
        if(!parkingSpotOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found");
        }
        this.deleteParkingSpotService.exec(parkingSpotOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully");
    }
}
