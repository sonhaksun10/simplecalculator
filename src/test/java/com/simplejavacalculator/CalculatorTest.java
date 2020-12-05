package com.simplejavacalculator;

import org.junit.jupiter.api.Test;
import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void calculateBi() {
        Calculator calc = new Calculator();

        Double res = calc.calculateBi(Calculator.BiOperatorModes.ADD, 2.0);
        assertEquals(NaN, res);

        res = calc.calculateBi(Calculator.BiOperatorModes.MINUS, 4.5);
        assertEquals(6.5, res);

        res = calc.calculateBi(Calculator.BiOperatorModes.MULTIPLY, 0.5);
        assertEquals(6.0, res);

        res = calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, 2.0);
        assertEquals(12.0, res);

        res = calc.calculateBi(Calculator.BiOperatorModes.XPOWEROFY, 2.0);
        assertEquals(6.0, res);

        res = calc.calculateBi(Calculator.BiOperatorModes.NORMAL, 2.0);
        assertEquals(36.0, res);

        res = calc.calculateBi(Calculator.BiOperatorModes.NORMAL, 2.0);
        assertEquals(NaN, res);
    }

    @Test
    void testNormal(){
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.ADD, 0.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateEqual(2.0);
        assertEquals(2.0, res);
    }

    @Test
    void testAdd() {
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.ADD, 2.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.ADD, 2.0);
        assertEquals(4.0, res);

        calc.reset();
        calc.calculateBi(Calculator.BiOperatorModes.ADD, 2.0);
        res = calc.calculateBi(Calculator.BiOperatorModes.ADD, 0.0);
        assertEquals(2.0, res);
    }

    @Test
    void testMultiply() {
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.MULTIPLY, 2.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.MULTIPLY, 2.0);
        assertEquals(4.0, res);

    }

    @Test
    void testminus() {
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.MINUS, 2.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.MINUS, 2.5);
        assertEquals(-0.5, res);

    }

    @Test
    void testdivide() {
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, 2.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, -0.5);
        assertEquals(-4.0, res);

    }

    @Test
    void test_dividebyzero(){
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, 2.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, 0.0);
        assertEquals(Double.POSITIVE_INFINITY, res);
    }

    @Test
    void testpower() {
        Calculator calc = new Calculator();

        // first opreation always give Nan
        Double res = calc.calculateBi(Calculator.BiOperatorModes.XPOWEROFY, 4.0);
        assertEquals(NaN, res);

        // second operation
        res = calc.calculateBi(Calculator.BiOperatorModes.XPOWEROFY, -0.5);
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

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.SQUARE,0.3);
        assertEquals(0.09, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.SQUAREROOT,0.09);
        assertEquals(0.3, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.ONEDEVIDEBY,0.25);
        assertEquals(4.0, res);
    }

    @Test
    void MonoPart2() {
        Calculator calc = new Calculator();

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.COS, 75.);
        assertEquals(Math.cos(75.), res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.SIN, 75.);
        assertEquals(Math.sin(75.), res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.TAN, 75.);
        assertEquals(Math.tan(75.), res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.TAN, 270.);
        assertEquals(NaN, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.TAN, 360.);
        assertEquals(0.0, res);
    }

    @Test
    void MonoPart3(){
        Calculator calc = new Calculator();

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.LOG,5.2);
        assertEquals(Math.log10(5.2), res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.RATE,79.);
        assertEquals(0.79, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.ABS,-3.14);
        assertEquals(3.14, res);
    }

    @Test
    void exception_in_onedivideby(){
        Calculator calc = new Calculator();

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.ONEDEVIDEBY,0.0);
        assertEquals(Double.POSITIVE_INFINITY, res);
    }

    @Test
    void exception_in_squareroot(){
        Calculator calc = new Calculator();

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.SQUAREROOT,0.0);
        assertEquals(0., res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.SQUAREROOT,-30.0);
        assertEquals(NaN, res);
    }

    @Test
    void exception_in_log(){
        Calculator calc = new Calculator();

        Double res = calc.calculateMono(Calculator.MonoOperatorModes.LOG,0.0);
        assertEquals(Double.NEGATIVE_INFINITY, res);

        res = calc.calculateMono(Calculator.MonoOperatorModes.LOG,-0.3);
        assertEquals(NaN, res);
    }

}