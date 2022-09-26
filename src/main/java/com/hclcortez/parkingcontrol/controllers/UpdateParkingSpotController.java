package com.hclcortez.parkingcontrol.controllers;

import com.hclcortez.parkingcontrol.dtos.ParkingSpotDTO;
import com.hclcortez.parkingcontrol.models.ParkingSpot;
import com.hclcortez.parkingcontrol.services.GetOneParkingSpotService;
import com.hclcortez.parkingcontrol.services.UpdateParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UpdateParkingSpotController {

    final UpdateParkingSpotService updateParkingSpotService;
    final GetOneParkingSpotService getOneParkingSpotService;

    public UpdateParkingSpotController(UpdateParkingSpotService updateParkingSpotService, GetOneParkingSpotService getOneParkingSpotService) {
        this.updateParkingSpotService = updateParkingSpotService;
        this.getOneParkingSpotService = getOneParkingSpotService;
    }

    @PutMapping("/parking-spot/{id}")
    public ResponseEntity<Object> handle(@PathVariable(value = "id") UUID id, @RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
        Optional<ParkingSpot> parkingSpotOptional = getOneParkingSpotService.exec(id);
        System.out.println(parkingSpotOptional);
        if(!parkingSpotOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot ot found");
        }

        var parkinSpot = new ParkingSpot();

        BeanUtils.copyProperties(parkingSpotDTO, parkinSpot);
        parkinSpot.setId(parkingSpotOptional.get().getId());
        parkinSpot.setRegisterDate(parkingSpotOptional.get().getRegisterDate());

        return ResponseEntity.status(HttpStatus.OK).body(this.updateParkingSpotService.exec(parkinSpot));
    }
}
