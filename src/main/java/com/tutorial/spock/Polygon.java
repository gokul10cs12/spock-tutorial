package com.tutorial.spock;

import com.tutorial.spock.Exception.TooFewSidesException;

public class Polygon  {
    int numberOfSides;
    Renderer renderer;
    public  Polygon(){}

    public  Polygon(int numberOfSides){
        if(numberOfSides <=0){
            throw  new TooFewSidesException("sides number cannot be ", numberOfSides);
        }
        this.numberOfSides = numberOfSides;
    }

    public Polygon(int numberOfSides, Renderer renderer) {
        this.numberOfSides = numberOfSides;
        this.renderer = renderer;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public  int getNumberOfSides(){
        return  numberOfSides;
    }

    public void draw(){
        for (int i = 0; i < numberOfSides; i++) {
            renderer.drawLine();
        }

    }


}
