package com.tutorial.spock;

public class Palette {
    private final Color primaryColor;

    Palette(Color primaryColor){
        this.primaryColor = primaryColor;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }
}
