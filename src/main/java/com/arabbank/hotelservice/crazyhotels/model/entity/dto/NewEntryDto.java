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
    String city;
    LocalDate fromDate;
    LocalDate toDate;
    int numberOfAdults;
    String name;
    String rating;
    double price;
    double discount;
    List<String> roomAmenenties;
}
