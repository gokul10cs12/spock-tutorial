package com.tutorial.spock

import com.tutorial.spock.Exception.TooFewSidesException
import spock.lang.Specification
import spock.lang.Subject


class ExampleSpecification extends Specification{

    def "should be assert true"() {
        expect:  // called labels
        1==1
    }

    def "should given-when-then"() {
        /*
        def keyword is used to define an untyped variable or a function in Groovy
        * */
        given:
        def polygons = new Polygon(4)

        when:
        int sides = polygons.numberOfSides  //we can use getter or the name of the private field if getter is available

        then:
        sides==4
    }

    def "should given-when-then modified or simplified"() {
        /*
        def keyword is used to define an untyped variable or a function in Groovy
        * */
        when:
        int sides = new Polygon(4).numberOfSides  //we can use getter or the name of the private field if getter is available

        then:
        sides==4
    }
    def "should throw exception"() {
        when:
        new Polygon(0)

        then:
        def exception = thrown(TooFewSidesException)
        exception.getLocalizedMessage() == "sides number cannot be zero"
        exception.sides == 0
    }

    def "should throw exception with pipes(multiple negative cases)"() {
        when:
        new Polygon(sides)

        then:
        def exception = thrown(TooFewSidesException)
        exception.getLocalizedMessage() == "sides number cannot be zero"
        exception.sides == sides

        where:
        sides << [0,-1,-2] // pipes --> groovy uses each of these values and pass it to the test and iterate over each scenario
        // here left shift operation (operator overloading) used to show that pipeline of values are used to test the case.
    }

    def "should be able to create polygon with specific sides "(){
        when:
        def polygon = new Polygon(sides)

        then:
        polygon.numberOfSides == sides

        where:
        sides << [3,-2,5]
    }

    def "should be able to create polygon with specific sides --- better version "(){
        expect:
        new Polygon(sides).numberOfSides == sides

        where:
        sides << [3,2,5]
    }

    def "data tables test max of #a and #b is #max" () {
        expect:
        Math.max(a,b) == max

        where:  // here we used data tables.
        a | b | max
        23| 34 | 34
        33| 45 | 45
    }

    def "should be able to MOCK concrete class"() {
        given:
        Renderer renderer = Mock() // code to create a mock
        @Subject // says which method is being tested
        def polygon  = new Polygon(4, renderer)

        when:
        polygon.draw() //what will happen if we call the draw method

        then:
        4 * renderer.drawLine()
    }

    def "Should test with stub"() {
        given:
        //useful to provide data into the coder we are testing
        Palette palette = Stub()  // we can use Mock also in the case of stub() but no otherwise
        palette.getPrimaryColor() >> Color.RED // we use right shift to state that, when the method getPrimaryColor is called, return color as red.
        @Subject
        def renderer = new Renderer(palette)

        expect:
        renderer.getForegroundColor() == Color.RED // getForegroundColor inherently calls palette.getPrimaryColor


    }

    def "test with helper methods" (){
        given:
        Renderer renderer = Mock()
        def shapeFactory = new ShapeFactory(renderer)

        when:
        @Subject
        def polygon = shapeFactory.createDefaultPolygon();

        //if we have multiple checks / assertion to validate, move the checks in to a private helper class.

        then:
        checkDefaultShape(polygon, renderer)

    }

    private void checkDefaultShape(Polygon polygon, Renderer renderer){
        assert polygon.numberOfSides == 4
        assert polygon.renderer == null
    }


}
