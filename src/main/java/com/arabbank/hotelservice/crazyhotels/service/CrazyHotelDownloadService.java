package com.arabbank.hotelservice.crazyhotels.service;

import com.arabbank.hotelservice.crazyhotels.model.entity.CrazyHotelEntity;
import com.arabbank.hotelservice.crazyhotels.repository.CrazyHotelEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrazyHotelDownloadService {
    @Autowired
    public CrazyHotelEntityRepo crazyHotelEntityRepo;



}
