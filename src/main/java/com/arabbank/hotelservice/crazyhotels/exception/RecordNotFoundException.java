package com.arabbank.hotelservice.crazyhotels.exception;

public class RecordNotFoundException extends Exception{
    private String message;
    public RecordNotFoundException(String message){
        super(message);
        this.message=message;
    }
    public String printError(){
        return "No Matching Record Found";
    }
}
