package com.thy.cargo.InterlineFlights.service;

import com.thy.cargo.InterlineFlights.dto.agreement.AgreementDto;
import com.thy.cargo.InterlineFlights.dto.agreement.AgreementRequestDto;

import java.util.List;

public interface AgreementService {

    String createAgreement(AgreementDto agreementDto);
    List<AgreementDto> getAgreementsByCompanyId(AgreementRequestDto agreementRequestDto);
}
