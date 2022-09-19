package com.tutorial.spock.Exception;

public class TooFewSidesException extends  RuntimeException{
    public TooFewSidesException(String message){
        super(message);
    }
}
