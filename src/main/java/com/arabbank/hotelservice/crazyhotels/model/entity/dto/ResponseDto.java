package com.arabbank.hotelservice.crazyhotels.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    String name;
    double rating;
    double price;
    double discount;
    List<String> roomAmenenties;
}
