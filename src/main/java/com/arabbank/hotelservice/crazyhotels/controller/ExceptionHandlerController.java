package com.arabbank.hotelservice.crazyhotels.controller;

import com.arabbank.hotelservice.crazyhotels.exception.NameNotAddedException;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(value = NameNotAddedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleNameNitEntered(NameNotAddedException e){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setErrorcode(HttpStatus.NO_CONTENT.toString());
        errorDto.setMessage(e.printError());
        return errorDto;
    }
}
