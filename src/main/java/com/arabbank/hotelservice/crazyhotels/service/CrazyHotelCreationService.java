package com.arabbank.hotelservice.crazyhotels.service;

import com.arabbank.hotelservice.crazyhotels.exception.NameNotAddedException;
import com.arabbank.hotelservice.crazyhotels.exception.buisnessexception.RatingException;
import com.arabbank.hotelservice.crazyhotels.model.entity.CrazyHotelEntity;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.NewEntryDto;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.ResponseDto;
import com.arabbank.hotelservice.crazyhotels.repository.CrazyHotelEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrazyHotelCreationService extends AddedService{
    @Autowired
    public CrazyHotelEntityRepo crazyHotelEntityRepo;
    public ResponseDto createNewEntry(NewEntryDto newEntryDto) throws NameNotAddedException, RatingException {


            CrazyHotelEntity crazyHotelEntity = new CrazyHotelEntity();
            crazyHotelEntity.setCity(newEntryDto.getCity());
            crazyHotelEntity.setDiscount(newEntryDto.getDiscount());
            crazyHotelEntity.setFromDate(newEntryDto.getFromDate());
            crazyHotelEntity.setToDate(newEntryDto.getToDate());
            crazyHotelEntity.setPrice(newEntryDto.getPrice());
            crazyHotelEntity.setRid(newEntryDto.getRid());

            crazyHotelEntity.setName(newEntryDto.getName());
            crazyHotelEntity.setNumberOfAdults(newEntryDto.getNumberOfAdults());
            if(newEntryDto.getRating().length()>5||checkRating(newEntryDto.getRating())){
                throw new RatingException();
            }
            crazyHotelEntity.setRating(newEntryDto.getRating());
            crazyHotelEntity.setRoomAmenenties(newEntryDto.getRoomAmenenties());
            crazyHotelEntityRepo.save(crazyHotelEntity);
            ResponseDto responseDto=new ResponseDto();
            responseDto.setName(crazyHotelEntity.getName());
            responseDto.setRoomAmenenties(crazyHotelEntity.getRoomAmenenties());
            double rating=convertrating(crazyHotelEntity.getRating());
            responseDto.setRating(rating);
            responseDto.setDiscount(crazyHotelEntity.getDiscount());
            responseDto.setPrice(crazyHotelEntity.getPrice());
            return responseDto;

         // responseDto.setRating(convertIntoString(crazyHotelEntity.getRating()));

        }

       // return "New Entry Added";
    }




