package com.arabbank.hotelservice.crazyhotels.service;

import com.arabbank.hotelservice.crazyhotels.exception.NameNotAddedException;
import com.arabbank.hotelservice.crazyhotels.exception.buisnessexception.RatingException;
import com.arabbank.hotelservice.crazyhotels.model.entity.CrazyHotelEntity;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.NewEntryDto;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.RequestDto;
import com.arabbank.hotelservice.crazyhotels.model.entity.dto.ResponseDto;
import com.arabbank.hotelservice.crazyhotels.repository.CrazyHotelEntityRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CrazyHotelService extends AddedService{
    @Autowired
    public CrazyHotelEntityRepo crazyHotelEntityRepo;
    @Autowired
    private MongoTemplate mongoTemplate;



     public List<ResponseDto> searchByRequest(RequestDto requestDto){
         Query query=new Query();
         Criteria criteria =new Criteria()
                 .andOperator(
                         (Criteria.where("toDate").lte(requestDto.getToDate())),
                         Criteria.where("fromDate").gte(requestDto.getFromDate())
                 );
         query.addCriteria(criteria);
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


}
