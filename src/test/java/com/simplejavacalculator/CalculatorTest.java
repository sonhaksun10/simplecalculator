package com.simplejavacalculator;

import org.junit.jupiter.api.Test;
import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void calculateBi() {
        Calculator calc = new Calculator();

        Double res = calc.calculateBi(Calculator.BiOperatorModes.normal, 2.0);
        assertEquals(NaN,res);

        res = calc.calculateBi(Calculator.BiOperatorModes.add, 4.5);
        assertEquals(6.5, res);
    }

    @Test
    void testAdd() {
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.add, 2.0);
        assertEquals(res, Double.NaN);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.add, 2.0);
        assertEquals(res, 4.0);
    }

    @Test
    void testMultiply() {
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.multiply, 2.0);
        assertEquals(res, NaN);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.multiply, 2.0);
        assertEquals(res, 4.0);

    }

    @Test
    void calculateEqual() {
        Calculator calc = new Calculator();

        //one
        Double res = calc.calculateEqual(0.0);
        assertNotEquals(0.0, res);

        //two
        res = calc.calculateEqual(3.0);
        assertNotEquals(3.0, res);
    }

    @Test
    void reset() {
        Calculator calc = new Calculator();

        Double res = calc.reset();
        assertEquals(res,NaN);
    }

    @Test
    void calculateMono() {
        Calculator calc = new Calculator();

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.square,0.3);
        assertEquals(0.09, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.squareRoot,0.09);
        assertEquals(0.3, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy,0.25);
        assertEquals(4.0, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.cos,75.);
        assertEquals(Math.cos(75.), res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.sin,75.);
        assertEquals(Math.sin(75.), res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.tan,75.);
        assertEquals(Math.tan(75.), res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.tan,270.);
        assertEquals(NaN, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.tan,360.);
        assertEquals(0.0, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.log,5.2);
        assertEquals(Math.log10(5.2), res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.rate,79.);
        assertEquals(0.79, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.abs,-3.14);
        assertEquals(3.14, res);
    }
    /*
    @Test
    void calculateBi() {
    }
    */
}