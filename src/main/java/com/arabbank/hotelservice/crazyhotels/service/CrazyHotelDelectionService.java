package com.arabbank.hotelservice.crazyhotels.service;

import com.arabbank.hotelservice.crazyhotels.exception.NameNotAddedException;
import com.arabbank.hotelservice.crazyhotels.model.entity.CrazyHotelEntity;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.ResponseDto;
import com.arabbank.hotelservice.crazyhotels.repository.CrazyHotelEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrazyHotelDelectionService {
    @Autowired
    public CrazyHotelEntityRepo crazyHotelEntityRepo;
    public ResponseDto deleteBYRid(String rid) throws NameNotAddedException {
        Optional<CrazyHotelEntity> crazyHotelEntity= crazyHotelEntityRepo.findByRid(rid);
        if (crazyHotelEntity.isPresent()) {
            crazyHotelEntityRepo.deleteHotelByRid(rid);
            CrazyHotelEntity hotel =crazyHotelEntity.get();
            ResponseDto responseDto=new ResponseDto();
            responseDto.setPrice(hotel.getPrice());
            responseDto.setRating(hotel.getPrice());
            responseDto.setRoomAmenenties(hotel.getRoomAmenenties());
            responseDto.setDiscount(hotel.getDiscount());
            responseDto.setName(hotel.getName());

            return responseDto;

        }
        if(!crazyHotelEntity.isPresent()){
            throw new NameNotAddedException();
        }
        //  throw new NameNotAddedException();
        return null;
    }
}
