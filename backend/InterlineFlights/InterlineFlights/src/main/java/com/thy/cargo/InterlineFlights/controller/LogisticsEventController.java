package com.thy.cargo.InterlineFlights.controller;


import com.thy.cargo.InterlineFlights.dto.event.LogisticsEventDto;
import com.thy.cargo.InterlineFlights.service.LogisticsEventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/logisticsevent")
public class LogisticsEventController {

    private final LogisticsEventService logisticsEventService;

    @PostMapping()
    public ResponseEntity<String> createAgreement(@RequestBody LogisticsEventDto logisticsEventDto) {
        return ResponseEntity.ok(logisticsEventService.createLogisticsEvent(logisticsEventDto));
    }
}
