package com.thy.cargo.InterlineFlights.dto.or;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thy.cargo.InterlineFlights.dto.Context;
import de.escalon.hypermedia.hydra.mapping.Vocab;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;
import lombok.Getter;
import lombok.Setter;

@JsonldType("cargo:ExternalReference")
@JsonldNamespace(name = "cargo", uri = "https://onerecord.iata.org/ns/cargo#")
@JsonldResource
@Getter
@Setter
@Vocab("https://onerecord.iata.org/ns/cargo#")
public class ExternalReferenceOR {

    @JsonProperty("@context")
    private Context context;
    @JsonProperty("@id")
    private String id;
    @JsonProperty("cargo:originator")
    private String originator;
    @JsonProperty("cargo:documentLink")
    private String documentLink;
    @JsonProperty("cargo:documentName")
    private String documentName;
    @JsonProperty("cargo:documentType")
    private String documentType;
    @JsonProperty("cargo:documentIdentifier")
    private String documentIdentifier;
    @JsonProperty("cargo:validFrom")
    private DateTimeOR validFrom;
    @JsonProperty("cargo:validUntil")
    private DateTimeOR validUntil;

}
