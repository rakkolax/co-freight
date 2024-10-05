package com.thy.cargo.InterlineFlights.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.thy.cargo.InterlineFlights.dto.Context;
import com.thy.cargo.InterlineFlights.dto.ResultEnum;
import com.thy.cargo.InterlineFlights.dto.booking.BookingDto;
import com.thy.cargo.InterlineFlights.dto.or.*;
import com.thy.cargo.InterlineFlights.service.AuthServerService;
import com.thy.cargo.InterlineFlights.service.BookingService;
import ioinformarics.oss.jackson.module.jsonld.JsonldModule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {



    private final RestTemplate restTemplate;
    private final AuthServerService authServerService;

    @Value("${onerecord.id.base}")
    private String oneRecordIdBase;

    @Value("${onerecord.base.url}")
    private String oneRecordBaseUrl;

    @Value("${onerecord.logisticobject.url}")
    private String oneRecordLogisticsObjectUrl;





    @Override
    public String createBooking(BookingDto bookingDto) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JsonldModule());


        DimensionsOR dimensionsOR = new DimensionsOR();
        dimensionsOR.setHeight(bookingDto.getHeight());
        dimensionsOR.setWidth(bookingDto.getWidth());
        dimensionsOR.setLenght(bookingDto.getLenght());
        dimensionsOR.setVolume(bookingDto.getVolume());


        ShipmentOR shipmentOR = new ShipmentOR();

        shipmentOR.setTotalDimensions(List.of(dimensionsOR));

        WaybillOR waybillOR = new WaybillOR();

        waybillOR.setShipment(shipmentOR);

        BookingRequestOR bookingRequestOR = new BookingRequestOR();
        bookingRequestOR.setBookingOption(bookingDto.getBookingOptionId());

        Context context = new Context();
        context.setCargo("https://onerecord.iata.org/ns/cargo#");



        BookingOR bookingOR = new BookingOR();

        bookingOR.setId(oneRecordIdBase + bookingDto.getWaybillPrefix()+ "-"+bookingDto.getWaybillNumber());
        bookingOR.setContext(context);
        bookingOR.setIssuedForWaybill(waybillOR);
        bookingOR.setBookingRequest(bookingRequestOR);

        try {
            HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(bookingOR), getHttpHeaders());

            ResponseEntity<Void> responseEntity = restTemplate.postForEntity((oneRecordBaseUrl + oneRecordLogisticsObjectUrl), entity, Void.class);
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
