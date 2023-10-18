package com.arabbank.hotelservice.crazyhotels.exception;

public class NameNotAddedException extends Exception{
    private String message;
    public NameNotAddedException(){

    }
    public NameNotAddedException(String message){
        super(message);
        this.message=message;
    }
    public String printError(){
        return "Enter Proper Name!";
    }
}
