package com.arabbank.hotelservice.crazyhotels.service;


import com.arabbank.hotelservice.crazyhotels.model.entity.CrazyHotelEntity;
import com.arabbank.hotelservice.crazyhotels.repository.CrazyHotelEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddedService {
    @Autowired
    private CrazyHotelEntityRepo crazyHotelEntityrepo;

    public String convertIntoString(List<String> li){
        String result ="";
        for (String str:li
        ) {
            result= result+str+ " , ";
        }
        int lenght =result.length();
        result=result.substring(0,lenght-2);
        return  result;
    }
    public boolean checkExist(String name){
        Optional<CrazyHotelEntity> crazyHotelEntity= crazyHotelEntityrepo.findByName(name);
        if(crazyHotelEntity.isPresent()){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkRating(String rating){
        for (char c :rating.toCharArray()){
            if(c != '*' ){
                System.out.println("Invalid rating");
                return true;
            }

        }
        return false;
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
