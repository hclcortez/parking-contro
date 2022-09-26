package com.hclcortez.parkingcontrol.controllers;

import com.hclcortez.parkingcontrol.models.ParkingSpot;
import com.hclcortez.parkingcontrol.services.ListParkingSpotService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ListParkingSpotController {

    final ListParkingSpotService listParkingSpotService;

    public ListParkingSpotController(ListParkingSpotService listParkingSpotService) {
        this.listParkingSpotService = listParkingSpotService;
    }

    @GetMapping("/parking-spot")
    public ResponseEntity<Page<ParkingSpot>> handle(@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable){

        return ResponseEntity.status(HttpStatus.OK).body(listParkingSpotService.exec(pageable));
    }
}
