package com.thy.cargo.InterlineFlights.dto.or;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.thy.cargo.InterlineFlights.dto.Context;
import de.escalon.hypermedia.hydra.mapping.Vocab;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;
import lombok.Getter;
import lombok.Setter;

@JsonldType("cargo:LogisticsEvent")
@JsonldNamespace(name = "cargo", uri = "https://onerecord.iata.org/ns/cargo#")
@JsonldResource
@Getter
@Setter
@Vocab("https://onerecord.iata.org/ns/cargo#")
public class LogisticsEventOR {


    @JsonProperty("@context")
    private Context context;

    @JsonProperty("@id")
    public String id;

    @JsonProperty("cargo:eventFor")
    private String eventFor;

    @JsonProperty("cargo:eventTimeType")
    private String eventTimeType;

    @JsonProperty("cargo:eventCode")
    private EventCodeOR eventCode;

    @JsonProperty("cargo:eventName")
    private String eventName;

    @JsonProperty("cargo:eventDate")
    private DateTimeOR eventDate;



}
