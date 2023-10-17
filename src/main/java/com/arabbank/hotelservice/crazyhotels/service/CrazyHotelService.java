package com.arabbank.hotelservice.crazyhotels.service;

import com.arabbank.hotelservice.crazyhotels.model.entity.CrazyHotelEntity;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.NewEntryDto;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.RequestDto;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.ResponseDto;
import com.arabbank.hotelservice.crazyhotels.repository.CrazyHotelEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrazyHotelService {
    @Autowired
    public CrazyHotelEntityRepo crazyHotelEntityRepo;
    @Autowired
    private MongoTemplate mongoTemplate;
     public String createNewEntry(NewEntryDto newEntryDto){
         CrazyHotelEntity crazyHotelEntity= new CrazyHotelEntity();
         crazyHotelEntity.setCity(newEntryDto.getCity());
         crazyHotelEntity.setDiscount(newEntryDto.getDiscount());
         crazyHotelEntity.setFromDate(newEntryDto.getFromDate());
         crazyHotelEntity.setToDate(newEntryDto.getToDate());
         crazyHotelEntity.setPrice(newEntryDto.getPrice());
         crazyHotelEntity.setName(newEntryDto.getName());
         crazyHotelEntity.setNumberOfAdults(newEntryDto.getNumberOfAdults());
         crazyHotelEntity.setRating(newEntryDto.getRating());
         crazyHotelEntity.setRoomAmenenties(newEntryDto.getRoomAmenenties());
         crazyHotelEntityRepo.save(crazyHotelEntity);
         return "New Entry Added";
     }
     public List<ResponseDto> searchByRequest(RequestDto requestDto){
         Query query=new Query();
         query.addCriteria(Criteria.where("toDate").lte(requestDto.getToDate()));
         query.addCriteria(Criteria.where("fromDate").gte(requestDto.getFromDate()));
         query.addCriteria(Criteria.where("city").is(requestDto.getCity()));

         List<CrazyHotelEntity> crazyHotelEntityList =mongoTemplate.find(query,CrazyHotelEntity.class);
         List<ResponseDto> responseDtoList=new ArrayList<>();

         for (CrazyHotelEntity che:crazyHotelEntityList
              ) {
             ResponseDto responseDto=new ResponseDto();
             System.out.println(che);
             double rating=convertrating(che.getRating());
             responseDto.setRating(rating);
             responseDto.setDiscount(che.getDiscount());
             responseDto.setRoomAmenenties(che.getRoomAmenenties());
             responseDto.setPrice(che.getPrice());
             responseDto.setName(che.getName());
             responseDtoList.add(responseDto);
         }
  return  responseDtoList;
     }
     public int convertrating(String text){
         int count = 0;
         for (char c : text.toCharArray()) {
             if (c == '*') {
                 count++;
             }
         }
         return count;

     }
}
