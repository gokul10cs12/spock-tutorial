package com.tutorial.spock;

import com.tutorial.spock.Exception.TooFewSidesException;

public class Polygon {
    private final int numberOfSides;

    public  Polygon(int numberOfSides){
        if(numberOfSides <=0){
            throw  new TooFewSidesException("sides number cannot be zero");
        }
        this.numberOfSides = numberOfSides;
    }

    public  int getNumberOfSides(){
        return  numberOfSides;
    }
}
