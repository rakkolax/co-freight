package com.thy.cargo.InterlineFlights.controller;


import com.thy.cargo.InterlineFlights.dto.agreement.AgreementDto;
import com.thy.cargo.InterlineFlights.dto.booking.BookingDto;
import com.thy.cargo.InterlineFlights.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping()
    public ResponseEntity<String> createAgreement(@RequestBody BookingDto bookingDto) {
        return ResponseEntity.ok(bookingService.createBooking(bookingDto));
    }}
