package com.thy.cargo.InterlineFlights.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Context {
    @JsonProperty("cargo")
    private String cargo;


}
