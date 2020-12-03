package com.simplejavacalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
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
        assertEquals(res, Double.NaN);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.multiply, 2.0);
        assertEquals(res, 4.0);
    }
    /*
    @Test
    void calculateBi() {
    }

    @Test
    void calculateEqual() {
    }

    @Test
    void reset() {
    }

    @Test
    void calculateMono() {
    }*/
}