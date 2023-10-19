package com.arabbank.hotelservice.crazyhotels.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewEntryDto {
    private String rid;
    private String city;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int numberOfAdults;
    private String name;
    private String rating;
    private double price;
    private  double discount;
    private List<String> roomAmenenties;
}
