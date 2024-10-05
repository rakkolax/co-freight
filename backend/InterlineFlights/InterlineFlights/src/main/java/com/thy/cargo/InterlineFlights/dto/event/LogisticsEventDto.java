package com.thy.cargo.InterlineFlights.dto.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogisticsEventDto {
    private String eventFor;
    private String eventTimeType;
    private String eventCode;
    private String eventName;
    private String eventDate;
    private String bookingId;
    private String logisticsEventId;
    private String codeListName;


}
