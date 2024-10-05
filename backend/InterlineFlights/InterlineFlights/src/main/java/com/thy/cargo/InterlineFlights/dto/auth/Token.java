package com.thy.cargo.InterlineFlights.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {

    private String access_token;
    private String token_type;
    private int expires_in;
    private String scope;
}
