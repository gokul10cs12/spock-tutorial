package com.tutorial.spock.Exception;

public class TooFewSidesException extends  RuntimeException{

    private final int sides;
    public TooFewSidesException(String message, int sides){
        super(message+ (sides));
        this.sides = sides;
    }

    public int getSides() {
        return sides;
    }
}
