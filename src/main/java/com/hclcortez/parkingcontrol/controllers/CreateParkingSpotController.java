package com.hclcortez.parkingcontrol.controllers;

import com.hclcortez.parkingcontrol.dtos.ParkingSpotDTO;
import com.hclcortez.parkingcontrol.models.ParkingSpot;
import com.hclcortez.parkingcontrol.services.CreateParkingSpotService;
import com.hclcortez.parkingcontrol.services.CustomValidationParkingSpot;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/api")
public class CreateParkingSpotController {

    final CreateParkingSpotService createParkingSpotService;
    final CustomValidationParkingSpot customValidationParkingSpot;

    public CreateParkingSpotController(CreateParkingSpotService createParkingSpotService, CustomValidationParkingSpot customValidationParkingSpot) {
        this.createParkingSpotService = createParkingSpotService;
        this.customValidationParkingSpot = customValidationParkingSpot;
    }

    @PostMapping("/parking-spot")
    @Transactional
    public ResponseEntity<Object> handle(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
        var parkingSpot = new ParkingSpot();

        if(this.customValidationParkingSpot.existsByLicensePlateCar(parkingSpotDTO.getLicensePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use");
        }
        if(this.customValidationParkingSpot.existsByParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use");
        }
        if(this.customValidationParkingSpot.existsByApartmentAndBlock(parkingSpotDTO.getApartment(), parkingSpotDTO.getBlock())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block");
        }

        BeanUtils.copyProperties(parkingSpotDTO, parkingSpot);
        parkingSpot.setRegisterDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(createParkingSpotService.exec(parkingSpot));
    }
}
