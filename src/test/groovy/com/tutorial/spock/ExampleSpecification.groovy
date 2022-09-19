package com.tutorial.spock

import com.tutorial.spock.Exception.TooFewSidesException
import spock.lang.Specification

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

    def "should be able to mock concrete class"() {
        
    }


}
