package com.tutorial.spock;

public class Renderer {
    private final Palette palette;

    Renderer(Palette palette){
        this.palette = palette;
    }

    public void drawLine(){}

    public Color getForegroundColor(){
        return palette.getPrimaryColor();
    }
}
