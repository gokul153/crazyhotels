package com.arabbank.hotelservice.crazyhotels.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "crazyhotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrazyHotelEntity {
    private String city;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int numberOfAdults;
    private String name;
    private String rating;
    private double price;
    private double discount;
    private List<String> roomAmenenties;

}
