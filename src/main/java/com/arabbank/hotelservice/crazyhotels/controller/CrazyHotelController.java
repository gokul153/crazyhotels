package com.arabbank.hotelservice.crazyhotels.controller;

import com.arabbank.hotelservice.crazyhotels.exception.NameNotAddedException;
import com.arabbank.hotelservice.crazyhotels.exception.buisnessexception.RatingException;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.NewEntryDto;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.RequestDto;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.ResponseDto;
import com.arabbank.hotelservice.crazyhotels.service.CrazyHotelCreationService;
import com.arabbank.hotelservice.crazyhotels.service.CrazyHotelDelectionService;
import com.arabbank.hotelservice.crazyhotels.service.CrazyHotelService;

import com.arabbank.hotelservice.crazyhotels.service.CrazyHotelUpdationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
public class CrazyHotelController {
    @Autowired
    private CrazyHotelService crazyHotelService;
    @Autowired
    private CrazyHotelCreationService creationService;
    @Autowired
    private CrazyHotelUpdationService crazyHotelUpdationService;
    @Autowired
    private CrazyHotelDelectionService crazyHotelDelectionService;

    @PostMapping("/newentry")
    public ResponseDto createNewEntry(@RequestBody NewEntryDto newEntryDto) throws NameNotAddedException, RatingException {

        return creationService.createNewEntry(newEntryDto);
    }

    @GetMapping("/hotels")
    public List<ResponseDto> gethotel(@RequestParam String city, @RequestParam LocalDate fromDate, @RequestParam LocalDate toDate , @RequestParam int noOfAdults){
           RequestDto requestDto=new RequestDto();
           requestDto.setCity(city);
           requestDto.setToDate(toDate);
           requestDto.setNoOfAdults(noOfAdults);
           requestDto.setFromDate(fromDate);

           return crazyHotelService.searchByRequest(requestDto);
    }
    @PutMapping("/hotel")
   public ResponseDto update_entry(@RequestParam String name,@RequestParam Double amount) throws NameNotAddedException {
        return crazyHotelUpdationService.updateByRname(name,amount);
   }
    @DeleteMapping("/hotel")
    public ResponseDto deleteRecord(@RequestParam String rid) throws NameNotAddedException {
       // return crazyHotelService.deleteBYRid(rid);
        return crazyHotelDelectionService.deleteBYRid(rid);
    }
}
