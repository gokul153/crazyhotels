package com.arabbank.hotelservice.crazyhotels.repository;

import com.arabbank.hotelservice.crazyhotels.model.entity.CrazyHotelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CrazyHotelEntityRepo extends MongoRepository<CrazyHotelEntity ,String> {
    Optional<CrazyHotelEntity> findBycity(String s);
   // Optional<CrazyHotelEntity> findByRid(String id);
  //  Optional<CrazyHotelEntity> findByName(String name);

}
