package com.simplejavacalculator;

import org.junit.jupiter.api.Test;
import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void calculateBi() {
        Calculator calc = new Calculator();

        Double res = calc.calculateBi(Calculator.BiOperatorModes.add, 2.0);
        assertEquals(NaN, res);

        res = calc.calculateBi(Calculator.BiOperatorModes.minus, 4.5);
        assertEquals(6.5, res);

        res = calc.calculateBi(Calculator.BiOperatorModes.multiply, 0.5);
        assertEquals(6.0, res);

        res = calc.calculateBi(Calculator.BiOperatorModes.divide, 2.0);
        assertEquals(12.0, res);

        res = calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, 2.0);
        assertEquals(6.0, res);

        res = calc.calculateBi(Calculator.BiOperatorModes.normal, 2.0);
        assertEquals(36.0, res);

        res = calc.calculateBi(Calculator.BiOperatorModes.normal, 2.0);
        assertEquals(NaN, res);
    }

    @Test
    void testNormal(){
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.add, 0.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateEqual(2.0);
        assertEquals(2.0, res);
    }

    @Test
    void testAdd() {
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.add, 2.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.add, 2.0);
        assertEquals(4.0, res);

        calc.reset();
        calc.calculateBi(Calculator.BiOperatorModes.add, 0.0);
        res = calc.calculateBi(Calculator.BiOperatorModes.add, 2.0);
        assertEquals(2.0, res);
    }

    @Test
    void testMultiply() {
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.multiply, 2.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.multiply, 2.0);
        assertEquals(4.0, res);

    }

    @Test
    void testminus() {
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.minus, 2.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.minus, 2.5);
        assertEquals(-0.5, res);

    }

    @Test
    void testdivide() {
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.divide, 2.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.divide, -0.5);
        assertEquals(-4.0, res);

    }

    @Test
    void test_dividebyzero(){
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.divide, 2.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.divide, 0.0);
        assertEquals(Double.POSITIVE_INFINITY, res);
    }

    @Test
    void testpower() {
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, 4.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, -0.5);
        assertEquals(0.5, res);

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
        assertEquals(NaN, res);
    }

    @Test
    void MonoPart1() {
        Calculator calc = new Calculator();

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.square,0.3);
        assertEquals(0.09, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.squareRoot,0.09);
        assertEquals(0.3, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy,0.25);
        assertEquals(4.0, res);
    }

    @Test
    void MonoPart2() {
        Calculator calc = new Calculator();

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.cos, 75.);
        assertEquals(Math.cos(75.), res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.sin, 75.);
        assertEquals(Math.sin(75.), res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.tan, 75.);
        assertEquals(Math.tan(75.), res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.tan, 270.);
        assertEquals(NaN, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.tan, 360.);
        assertEquals(0.0, res);
    }

    @Test
    void MonoPart3(){
        Calculator calc = new Calculator();

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.log,5.2);
        assertEquals(Math.log10(5.2), res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.rate,79.);
        assertEquals(0.79, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.abs,-3.14);
        assertEquals(3.14, res);
    }

    @Test
    void exception_in_onedivideby(){
        Calculator calc = new Calculator();

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy,0.0);
        assertEquals(Double.POSITIVE_INFINITY, res);
    }

    @Test
    void exception_in_squareroot(){
        Calculator calc = new Calculator();

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.squareRoot,0.0);
        assertEquals(0., res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.squareRoot,-30.0);
        assertEquals(NaN, res);
    }

    @Test
    void exception_in_log(){
        Calculator calc = new Calculator();

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.log,0.0);
        assertEquals(Double.NEGATIVE_INFINITY, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.log,-0.3);
        assertEquals(NaN, res);
    }

}