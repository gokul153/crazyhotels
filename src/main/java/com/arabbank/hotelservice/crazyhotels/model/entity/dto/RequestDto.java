package com.arabbank.hotelservice.crazyhotels.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private String city;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int noOfAdults;
}
