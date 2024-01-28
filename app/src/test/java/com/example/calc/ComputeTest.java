package com.example.calc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ComputeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addDigit() {
        Compute c = new Compute();

        assertEquals("0", c.getResult());
        c.addDigit("1");
        assertEquals("1", c.getResult());
        c.addDigit("2");
        assertEquals("12", c.getResult());
    }

    @Test
    public void addDec() {
        Compute c = new Compute();
        c.addDigit("1");
        assertEquals("1", c.getResult());
        c.addDec();
        c.addDigit("2");
        assertEquals("1.2", c.getResult());
    }

    @Test
    public void calculate() {
        Compute c = new Compute();
        c.addDigit("1");
        c.calculate("+");
        c.addDigit("1");
        c.calculate("=");
        assertEquals("2.0", c.getResult());

        c.addDigit("2");
        c.calculate("-");
        c.addDigit("1");
        c.calculate("=");
        assertEquals("1.0", c.getResult());

        c.addDigit("3");
        c.calculate("×");
        c.addDigit("3");
        c.calculate("=");
        assertEquals("9.0", c.getResult());

        c.addDigit("9");
        c.calculate("÷");
        c.addDigit("3");
        c.calculate("=");
        assertEquals("3.0", c.getResult());
    }

    @Test
    public void clearAll() {
        Compute c = new Compute();
        c.addDigit("1");
        c.clearAll();
        assertEquals("", c.getResult());
    }
}