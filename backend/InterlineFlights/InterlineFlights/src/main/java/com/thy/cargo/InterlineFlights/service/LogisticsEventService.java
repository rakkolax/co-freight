package com.thy.cargo.InterlineFlights.service;

import com.thy.cargo.InterlineFlights.dto.event.LogisticsEventDto;

public interface LogisticsEventService {

    String createLogisticsEvent(LogisticsEventDto logisticsEventDto);
}
