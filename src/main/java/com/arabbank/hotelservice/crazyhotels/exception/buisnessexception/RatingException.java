package com.arabbank.hotelservice.crazyhotels.exception.buisnessexception;

public class RatingException extends Exception{
    private String message;
    public RatingException(){

    }
    public RatingException(String message){
        super(message);
        this.message=message;
    }
    public String printError(){
        return "Enter Proper rating less than 5";
    }
}
