package com.thy.cargo.InterlineFlights.service.impl;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.thy.cargo.InterlineFlights.config.DisableSSL;
import com.thy.cargo.InterlineFlights.service.AuthServerService;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class AuthServerServiceImpl implements AuthServerService {


    @Value("${auth.auth-server-url}")
    private String keycloakAuthServerUrl;

    @Value("${auth.client-id}")
    private String clientId;

    @Value("${auth.client-secret}")
    private String clientSecret;

    @Value("${auth.username}")
    private String username;

    @Value("${auth.password}")
    private String password;


    private final RestTemplate restTemplate;

    private OAuth2User currentUser;
    private static OAuth2AccessTokenResponse currentToken;
    private static LocalDateTime tokenTakenTime;



    private static final Logger logger = LogManager.getLogger(AuthServerServiceImpl.class);





    @Override
    public String getToken() {
       /*  URI uri = URI.create(keycloakAuthServerUrl);
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        params.put("username", username);
        params.put("password", password);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        OAuth2User user = authenticateUser(username, password);

       HttpEntity<String> entity = new HttpEntity<>(getParamsString(params), headers);

        Token response = restTemplate.postForObject(uri, entity, Token.class);
*/

        OAuth2AccessTokenResponse storedOneRecordToken=getStoredToken();

        if(storedOneRecordToken!=null){
            return storedOneRecordToken.getAccessToken();
        }

        OAuth2AccessTokenResponse token = takeToken();

        tokenTakenTime=LocalDateTime.now();
        currentToken = token;




        return token == null ? null : token.getAccessToken();
    }



    private static OAuth2AccessTokenResponse getStoredToken() {
        if(currentToken!=null && tokenTakenTime!=null && tokenTakenTime.isAfter(LocalDateTime.now().minusSeconds(15))){
            return currentToken;
        }
        return null;
    }





    private String getParamsString(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        for (String key : params.keySet()) {
            builder.append(key).append("=").append(params.get(key)).append("&");
        }
        return builder.toString();
    }

    public String getAccessToken() {
        if (currentUser == null) {
            throw new RuntimeException("user_not_logged_in");
        }
        if (currentUser.accessToken.getExpiresAt().isBefore(Instant.now())) {
            logger.info("Refresh token {}", currentUser.accessToken);
            currentUser = sendTokenRefreshRequest(currentUser.getRefreshToken());
        }
        return currentUser.accessToken.getTokenValue();
    }


    protected OAuth2User resposeToUser(OAuth2AccessTokenResponse response) {
        var jwtDecoder = JwtDecoders
                .fromIssuerLocation(keycloakAuthServerUrl);
        Jwt accessToken = jwtDecoder.decode(response.getAccessToken());
        return OAuth2User.builder().accessToken(accessToken).response(response).build();
    }


    public OAuth2User authenticateUser(String username, String password) {
        logger.info("Try to login user {}", username);
        var token = sendUserAuthenticationRequest(username, password);
        logger.debug("User {} successfully log in {}", username, token);
        currentUser = token;
        return currentUser;
    }

    OAuth2User sendUserAuthenticationRequest(String username, String password) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("username", username);
        map.add("password", password);
        var token = sendKeycloakRequest(map);
        return resposeToUser(token);
    }
    OAuth2User sendTokenRefreshRequest(String refreshToken) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "refresh_token");
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("refresh_token", refreshToken);
        var token = sendKeycloakRequest(map);
        return resposeToUser(token);
    }

    OAuth2AccessTokenResponse takeToken(){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("username", username);
        map.add("password", password);
        var token = sendKeycloakRequest(map);
        return token;
    }


    OAuth2AccessTokenResponse sendKeycloakRequest(MultiValueMap<String, String> map) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        DisableSSL.execute();
        ResponseEntity<OAuth2AccessTokenResponse> exchange = restTemplate.exchange(
                keycloakAuthServerUrl, HttpMethod.POST, request,
                OAuth2AccessTokenResponse.class);
        return exchange.getBody();
    }








    @Getter
    @Setter
    @ToString
    public static class OAuth2AccessTokenResponse {
        @JsonProperty(OAuth2ParameterNames.ACCESS_TOKEN)
        private String accessToken;

        @JsonProperty(OAuth2ParameterNames.EXPIRES_IN)
        private String expiresIn;

        @JsonProperty("refresh_expires_in")
        private String refreshExpiresIn;

        @JsonProperty(OAuth2ParameterNames.REFRESH_TOKEN)
        private String refreshToken;

        @JsonProperty(OAuth2ParameterNames.TOKEN_TYPE)
        private String tokenType;

        @JsonProperty("not-before-policy")
        private String notBeforePolicy;

        @JsonProperty("session_state")
        private String sessionState;

        @JsonProperty(OAuth2ParameterNames.SCOPE)
        private String scope;
    }


    @Data
    @Builder
    @RequiredArgsConstructor
    public static class OAuth2User {
        private final Jwt accessToken;
        private final OAuth2AccessTokenResponse response;

        public String getRefreshToken() {
            return response.refreshToken;
        }
    }




}
