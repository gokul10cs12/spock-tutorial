package com.tutorial.spock;

public class ShapeFactory {
    private Renderer renderer;

    public Renderer getRenderer() {
        return renderer;
    }

    ShapeFactory(Renderer renderer){
        this.renderer = renderer;
    }
    Polygon createDefaultPolygon(){
        return new Polygon(4);
    }
}
