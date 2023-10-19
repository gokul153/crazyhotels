package com.arabbank.hotelservice.crazyhotels.service;

import com.arabbank.hotelservice.crazyhotels.exception.NameNotAddedException;
import com.arabbank.hotelservice.crazyhotels.model.entity.CrazyHotelEntity;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.ResponseDto;
import com.arabbank.hotelservice.crazyhotels.repository.CrazyHotelEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CrazyHotelUpdationService extends AddedService{
    @Autowired
    public CrazyHotelEntityRepo crazyHotelEntityRepo;
    public ResponseDto updateByRname(String hotelName,Double amount) throws NameNotAddedException {
        Optional<CrazyHotelEntity> crazyHotelEntity= crazyHotelEntityRepo.findByName(hotelName);
        System.out.println("Updating");
        if(crazyHotelEntity.isPresent()) {
            CrazyHotelEntity hotel = crazyHotelEntity.get();
            hotel.setPrice(amount);
            crazyHotelEntityRepo.save(hotel);
            ResponseDto responseDto=new ResponseDto();

            double rating=convertrating(hotel.getRating());
            responseDto.setRating(rating);
            responseDto.setDiscount(hotel.getDiscount());
            responseDto.setRoomAmenenties(hotel.getRoomAmenenties());
            responseDto.setPrice(hotel.getPrice());
            responseDto.setName(hotel.getName());
           return  responseDto;
        }
        if(!crazyHotelEntity.isPresent()){
            throw new NameNotAddedException();
        }

        return null;
    }
}
