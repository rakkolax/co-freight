package com.thy.cargo.InterlineFlights.controller;


import com.thy.cargo.InterlineFlights.service.AuthServerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1")
public class TestController {

    private final AuthServerService authServerService;


    @GetMapping("/tokentest")
    public ResponseEntity<String> getToken() {
        return ResponseEntity.ok(authServerService.getToken());
    }


}
