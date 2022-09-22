package com.hclcortez.parkingcontrol.controllers;

import com.hclcortez.parkingcontrol.dtos.ParkingSpotDTO;
import com.hclcortez.parkingcontrol.models.ParkingSpot;
import com.hclcortez.parkingcontrol.services.CreateParkingSpotService;
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

    public CreateParkingSpotController(CreateParkingSpotService createParkingSpotService) {
        this.createParkingSpotService = createParkingSpotService;
    }

    @PostMapping("/parking-spot")
    @Transactional
    public ResponseEntity<Object> handle(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
        var parkingSpot = new ParkingSpot();
        BeanUtils.copyProperties(parkingSpotDTO, parkingSpot);
        parkingSpot.setRegisterDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(createParkingSpotService.exec(parkingSpot));
    }
}
