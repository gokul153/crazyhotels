package com.arabbank.hotelservice.crazyhotels.controller;

import com.arabbank.hotelservice.crazyhotels.exception.NameNotAddedException;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.NewEntryDto;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.RequestDto;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.ResponseDto;
import com.arabbank.hotelservice.crazyhotels.service.CrazyHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
public class CrazyHotelController {
    @Autowired
    private CrazyHotelService crazyHotelService;

    @PostMapping("/newentry")
    public String createNewEntry(@RequestBody NewEntryDto newEntryDto) throws NameNotAddedException {
        return crazyHotelService.createNewEntry(newEntryDto);

    }

    @GetMapping("/gethotel")
    public List<ResponseDto> gethotel(@RequestParam String city, @RequestParam LocalDate fromDate, @RequestParam LocalDate toDate , @RequestParam int noOfAdults){
           RequestDto requestDto=new RequestDto();
           requestDto.setCity(city);
           requestDto.setToDate(toDate);
           requestDto.setNoOfAdults(noOfAdults);
           requestDto.setFromDate(fromDate);
           return crazyHotelService.searchByRequest(requestDto);
    }
//    @PutMapping("/hotel")
//    public String update_entry(@RequestParam String name,@RequestParam Double amount) {
//
//        return crazyHotelService.updateByRname(name,amount);
//    }

}
