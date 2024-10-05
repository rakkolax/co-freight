package com.thy.cargo.InterlineFlights.dto.or;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.escalon.hypermedia.hydra.mapping.Vocab;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;
import lombok.Getter;
import lombok.Setter;

@JsonldType("cargo:Dimensions")
@JsonldNamespace(name = "cargo", uri = "https://onerecord.iata.org/ns/cargo#")
@JsonldResource
@Getter
@Setter
@Vocab("https://onerecord.iata.org/ns/cargo#")
public class DimensionsOR {
    @JsonProperty("cargo:height")
    private String height;
    @JsonProperty("cargo:lenght")
    private String lenght;
    @JsonProperty("cargo:width")
    private String width;
    @JsonProperty("cargo:volume")
    private String volume;
}
