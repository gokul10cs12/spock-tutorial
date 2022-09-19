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
        thrown(TooFewSidesException)
    }
}
