package com.thy.cargo.InterlineFlights.dto.agreement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgreementDto {

    private String originatorCompanyId;
    private String documentName;
    private String documentLink;
    //private String documentType;
    private String documentIdentifier;
    private String validFrom;
    private String validUntil;
}
