package com.thy.cargo.InterlineFlights.dto.or;


import com.fasterxml.jackson.annotation.JsonProperty;
import de.escalon.hypermedia.hydra.mapping.Vocab;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;
import lombok.Getter;
import lombok.Setter;

@JsonldType("cargo:CO2Emissions")
@JsonldNamespace(name = "cargo", uri = "https://onerecord.iata.org/ns/cargo#")
@JsonldResource
@Getter
@Setter
@Vocab("https://onerecord.iata.org/ns/cargo#")
public class CO2EmissionsOR {


    @JsonProperty("cargo:calculatedEmissions")
    private String transportIdentifier;


}
