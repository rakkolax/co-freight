package com.thy.cargo.InterlineFlights.dto.booking;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDto {

    private String height;
    private String lenght;
    private String width;
    private String volume;
    private String waybillPrefix;
    private String waybillNumber;
    private String bookingOptionId;
}
