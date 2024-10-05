package com.thy.cargo.InterlineFlights.dto.or;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thy.cargo.InterlineFlights.dto.Context;
import de.escalon.hypermedia.hydra.mapping.Vocab;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;
import lombok.Getter;
import lombok.Setter;

@JsonldType("cargo:Booking")
@JsonldNamespace(name = "cargo", uri = "https://onerecord.iata.org/ns/cargo#")
@JsonldResource
@Getter
@Setter
@Vocab("https://onerecord.iata.org/ns/cargo#")
public class BookingOR {

    @JsonProperty("@context")
    private Context context;

    @JsonProperty("@id")
    private String id;

    @JsonProperty("cargo:issuedForWaybill")
    private WaybillOR issuedForWaybill;

    @JsonProperty("cargo:bookingRequest")
    private BookingRequestOR bookingRequest;


}
