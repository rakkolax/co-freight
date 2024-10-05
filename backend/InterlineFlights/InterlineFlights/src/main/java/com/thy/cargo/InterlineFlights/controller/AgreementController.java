package com.thy.cargo.InterlineFlights.controller;


import com.thy.cargo.InterlineFlights.dto.agreement.AgreementDto;
import com.thy.cargo.InterlineFlights.dto.agreement.AgreementRequestDto;
import com.thy.cargo.InterlineFlights.service.AgreementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/agreement")
public class AgreementController {

    private final AgreementService agreementService;

    @PostMapping()
    public ResponseEntity<String> createAgreement(@RequestBody AgreementDto agreementDto) {
        return ResponseEntity.ok(agreementService.createAgreement(agreementDto));
    }

    @PostMapping("/getAllAgreements")
    public ResponseEntity<List<AgreementDto>> getAgreements(@RequestBody AgreementRequestDto agreementRequestDto) {
        return ResponseEntity.ok(agreementService.getAgreementsByCompanyId(agreementRequestDto));
    }





}
