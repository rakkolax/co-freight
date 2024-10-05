package com.thy.cargo.InterlineFlights.service.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier;
import com.github.jsonldjava.utils.JsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.thy.cargo.InterlineFlights.config.DisableSSL;
import com.thy.cargo.InterlineFlights.config.HttpClientFactory;
import com.thy.cargo.InterlineFlights.dto.AgreementEnum;
import com.thy.cargo.InterlineFlights.dto.Context;
import com.thy.cargo.InterlineFlights.dto.ResultEnum;
import com.thy.cargo.InterlineFlights.dto.agreement.AgreementDto;
import com.thy.cargo.InterlineFlights.dto.agreement.AgreementRequestDto;
import com.thy.cargo.InterlineFlights.dto.or.DateTimeOR;
import com.thy.cargo.InterlineFlights.dto.or.ExternalReferenceOR;
import com.thy.cargo.InterlineFlights.dto.or.LogisticsObjectOR;
import com.thy.cargo.InterlineFlights.service.AgreementService;
import com.thy.cargo.InterlineFlights.service.AuthServerService;
import de.escalon.hypermedia.hydra.serialize.JacksonHydraSerializer;
import ioinformarics.oss.jackson.module.jsonld.JsonldModule;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class AgreementServiceImpl implements AgreementService {


    private final RestTemplate restTemplate;
    private final AuthServerService authServerService;

    @Value("${onerecord.id.base}")
    private String oneRecordIdBase;

    @Value("${cofreight.url}")
    private String coFreightUrl;

    @Value("${onerecord.base.url}")
    private String oneRecordBaseUrl;

    @Value("${onerecord.logisticobject.url}")
    private String oneRecordLogisticsObjectUrl;

    @Value("${onerecord.all.url}")
    private String oneRecordAllUrl;




    @Override
    public String createAgreement(AgreementDto agreementDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JsonldModule());





        ExternalReferenceOR externalReferenceOR = new ExternalReferenceOR();
        Context context = new Context();
        context.setCargo("https://onerecord.iata.org/ns/cargo#");
        externalReferenceOR.setContext(context);
        externalReferenceOR.setId(oneRecordIdBase + agreementDto.getDocumentIdentifier());
        externalReferenceOR.setOriginator(agreementDto.getOriginatorCompanyId());
        externalReferenceOR.setDocumentIdentifier(agreementDto.getDocumentIdentifier());
        externalReferenceOR.setDocumentType(AgreementEnum.INTERLINE_AGREEMENT.name());
        externalReferenceOR.setDocumentName(agreementDto.getDocumentName());
        externalReferenceOR.setDocumentLink(coFreightUrl + agreementDto.getDocumentIdentifier());

        DateTimeOR validFrom = new DateTimeOR();
        validFrom.setValue(agreementDto.getValidFrom());

        DateTimeOR validUntil = new DateTimeOR();
        validUntil.setValue(agreementDto.getValidUntil());

        externalReferenceOR.setValidFrom(validFrom);
        externalReferenceOR.setValidUntil(validUntil);






        try {
            HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(externalReferenceOR), getHttpHeaders());

            ResponseEntity<Void> responseEntity = restTemplate.postForEntity((oneRecordBaseUrl + oneRecordLogisticsObjectUrl), entity, Void.class);
            return ResultEnum.OK.name();
        } catch (Exception e) {
            return ResultEnum.FAIL.name();

        }
    }

    @Override
    public List<AgreementDto> getAgreementsByCompanyId(AgreementRequestDto agreementRequestDto) {

        try {
            List<AgreementDto> agreementDtoList= new ArrayList<>();
            StringBuilder oneRecoderUrlBuilder = new StringBuilder(oneRecordBaseUrl).append(oneRecordLogisticsObjectUrl).append("/").append(agreementRequestDto.getListOfAgreementId().get(0));

            agreementRequestDto.getListOfAgreementId().forEach(s -> {
                HttpEntity<String> entity = new HttpEntity<>(null, getHttpHeaders());

                DisableSSL.execute();
                //String a =restTemplate.getForEntity(oneRecoderUrlBuilder.toString(),  String.class).getBody();
                //String response = restTemplate.exchange((oneRecordBaseUrl + oneRecordAllUrl+"?limit=10000&offset=0&t=https://onerecord.iata.org/ns/cargo#ExternalReference"), HttpMethod.GET, entity, String.class).getBody();


                String response = restTemplate.exchange((oneRecoderUrlBuilder.toString()), HttpMethod.GET, entity, String.class).getBody();
                // ResponseEntity<String> responseEntity = restTemplate.exchange((oneRecordBaseUrl + oneRecordAllUrl+"?limit=10000&offset=0"),entity, String.class);

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JsonldModule());






                JsonObject agreementJsonObject = JsonParser.parseString(response)
                        .getAsJsonObject();


                AgreementDto agreementDto = new AgreementDto();

                agreementDto.setDocumentIdentifier(getJsonStringFromObject(agreementJsonObject, "documentIdentifier"));
                agreementDto.setDocumentLink(getJsonStringFromObject(agreementJsonObject, "documentLink"));
                agreementDto.setDocumentName(getJsonStringFromObject(agreementJsonObject, "documentName"));
                agreementDto.setOriginatorCompanyId(getJsonStringFromObject(agreementJsonObject, "originator"));
                //agreementDto.setValidUntil(getJsonStringFromObject(agreementJsonObject, "validUntil"));
                //agreementDto.setValidFrom(getJsonStringFromObject(agreementJsonObject, "validFrom"));
                agreementDtoList.add(agreementDto);
            });



            return agreementDtoList;

        } catch (Exception e) {
            return List.of();

        }


    }

    String getJsonStringFromObject(JsonObject jsonObject, String key) {
        String result = null;

        if (jsonObject != null) {
            //JsonElement jsonElement = jsonObject.get("cargo:" + key);
            JsonElement jsonElement = jsonObject.get(key);
            if (jsonElement != null) {
                result = jsonElement.getAsString();
            }
        }
        return result;
    }


    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String token = authServerService.getToken();
        headers.setBearerAuth(token);
        headers.add("Content-Type","application/ld+json; version=2.0.0-dev");
        headers.add("Accept","application/ld+json; version=2.0.0-dev");
        return headers;
    }




}
