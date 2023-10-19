package com.arabbank.hotelservice.crazyhotels.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private String name;
    private double rating;
    private double price;
    private double discount;
    private List<String> roomAmenenties;
}
