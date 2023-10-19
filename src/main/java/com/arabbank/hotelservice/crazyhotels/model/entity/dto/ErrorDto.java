package com.arabbank.hotelservice.crazyhotels.model.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorDto {
    private String message;
    private String errorcode;
}
