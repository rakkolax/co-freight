package com.thy.cargo.InterlineFlights.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thy.cargo.InterlineFlights.dto.Context;
import com.thy.cargo.InterlineFlights.dto.ResultEnum;
import com.thy.cargo.InterlineFlights.dto.event.LogisticsEventDto;
import com.thy.cargo.InterlineFlights.dto.or.DateTimeOR;
import com.thy.cargo.InterlineFlights.dto.or.EventCodeOR;
import com.thy.cargo.InterlineFlights.dto.or.LogisticsEventOR;
import com.thy.cargo.InterlineFlights.service.AuthServerService;
import com.thy.cargo.InterlineFlights.service.LogisticsEventService;
import ioinformarics.oss.jackson.module.jsonld.JsonldModule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
@Service
public class LogisticsEventServiceImpl implements LogisticsEventService {

    private static final String LOGISTICS_OBJECT_PARAM = "<logistics_object_param>";
    private static final String LOGISTICS_EVENT_PARAM = "<logistics_event_param>";

    @Value("${onerecord.id.base}")
    private String oneRecordIdBase;

    @Value("${onerecord.base.url}")
    private String oneRecordBaseUrl;

    @Value("${onerecord.logisticobject.url}")
    private String oneRecordLogisticsObjectUrl;

    @Value("${onerecord.get.logisticevent.url}")
    private String oneRecordLogisticsEventUrl;

    private final AuthServerService authServerService;
    private final RestTemplate restTemplate;




    @Override
    public String createLogisticsEvent(LogisticsEventDto logisticsEventDto) {

        String eventUrlAsString = oneRecordIdBase+ LOGISTICS_OBJECT_PARAM + oneRecordLogisticsEventUrl +
                LOGISTICS_EVENT_PARAM;



        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JsonldModule());

        LogisticsEventOR logisticsEventOr = new LogisticsEventOR();
        String logisticsEventIdUrl = eventUrlAsString.replaceAll(LOGISTICS_OBJECT_PARAM, logisticsEventDto.getBookingId()).replaceAll(LOGISTICS_EVENT_PARAM, logisticsEventDto.getLogisticsEventId());



        logisticsEventOr.setId(logisticsEventIdUrl);
        logisticsEventOr.setEventFor(logisticsEventDto.getEventFor());
        logisticsEventOr.setEventTimeType(logisticsEventDto.getEventTimeType());
        logisticsEventOr.setEventName(logisticsEventDto.getEventName());

        EventCodeOR eventCodeOr = new EventCodeOR();
        eventCodeOr.setCode(logisticsEventDto.getEventCode());
        eventCodeOr.setCodeListName(logisticsEventDto.getCodeListName());
        logisticsEventOr.setEventCode(eventCodeOr);
        DateTimeOR eventDateOr = new DateTimeOR();
        eventDateOr.setValue(logisticsEventDto.getEventDate());
        logisticsEventOr.setEventDate(eventDateOr);
        Context context = new Context();
        context.setCargo("https://onerecord.iata.org/ns/cargo#");
        logisticsEventOr.setContext(context);


        try {
            HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(logisticsEventOr), getHttpHeaders());

            ResponseEntity<Void> responseEntity = restTemplate.postForEntity((oneRecordBaseUrl + oneRecordLogisticsObjectUrl + "/"+ logisticsEventDto.getBookingId() + oneRecordLogisticsEventUrl), entity, Void.class);
            return ResultEnum.OK.name();
        } catch (Exception e) {
            return ResultEnum.FAIL.name();

        }

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
